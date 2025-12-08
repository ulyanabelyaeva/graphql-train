package org.belyaeva.service.book;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.belyaeva.dto.Book;
import org.belyaeva.dto.BookFilter;
import org.belyaeva.dto.NewBook;
import org.belyaeva.entity.BookEntity;
import org.belyaeva.entity.BookGenreRelationEntity;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.repository.BookRepository;
import org.belyaeva.repository.GenreRepository;
import org.belyaeva.service.book.api.BookMapper;
import org.belyaeva.service.book.api.BookService;
import org.belyaeva.service.book.api.BookSearchHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookSearchHelper bookSearchHelper;
    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookSearchHelper bookSearchHelper,
                           GenreRepository genreRepository,
                           BookRepository bookRepository,
                           BookMapper bookMapper) {
        this.bookSearchHelper = bookSearchHelper;
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks(BookFilter request, DataFetchingFieldSelectionSet selectionSet) {
        Specification<BookEntity> specification = bookSearchHelper.createSpecification(request, selectionSet);
        Pageable pageable = bookSearchHelper.createPageable(request);
        Page<BookEntity> page = bookRepository.findAll(specification, pageable);
        return bookMapper.toDtoList(page, selectionSet);
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBookById(long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Book was not found by id " + id));
    }

    @Override
    @Transactional
    public Long addNewBook(NewBook request) {
        BookEntity newBook = new BookEntity()
                .setName(request.getName())
                .setPageCount(request.getPageCount());

        if (!request.getGenreIds().isEmpty()) {
            List<GenreEntity> genres = genreRepository.findAllById(request.getGenreIds());
            List<BookGenreRelationEntity> newBookRelations = genres.stream()
                    .map(genre -> new BookGenreRelationEntity()
                            .setBook(newBook)
                            .setGenre(genre))
                    .toList();
            newBook.setGenreRelations(newBookRelations);
        }
        BookEntity saved = bookRepository.save(newBook);
        return saved.getId();
    }
}
