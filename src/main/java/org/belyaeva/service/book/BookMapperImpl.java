package org.belyaeva.service.book;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.belyaeva.dto.Author;
import org.belyaeva.dto.Book;
import org.belyaeva.dto.Genre;
import org.belyaeva.entity.BookEntity;
import org.belyaeva.entity.BookGenreRelationEntity;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.entity.projection.BookGenreProjection;
import org.belyaeva.repository.GenreRepository;
import org.belyaeva.service.author.api.AuthorMapper;
import org.belyaeva.service.book.api.BookMapper;
import org.belyaeva.service.genre.api.GenreMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Component
public class BookMapperImpl implements BookMapper {

    private final GenreRepository genreRepository;
    private final AuthorMapper authorMapper;
    private final GenreMapper genreMapper;

    public BookMapperImpl(GenreRepository genreRepository,
                          AuthorMapper authorMapper,
                          GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.authorMapper = authorMapper;
        this.genreMapper = genreMapper;
    }

    @Override
    @Transactional(propagation = MANDATORY)
    public Book toDto(BookEntity book) {
        Author authorDto = authorMapper.toDto(book.getAuthor());
        List<GenreEntity> genres = this.getGenres(book);
        List<Genre> genreDtoList = genreMapper.toDtoList(genres);
        return new Book()
                .setId(book.getId())
                .setName(book.getName())
                .setPageCount(book.getPageCount())
                .setAuthor(authorDto)
                .setGenres(genreDtoList);
    }

    @Override
    @Transactional(propagation = MANDATORY)
    public List<Book> toDtoList(Page<BookEntity> page,
                                DataFetchingFieldSelectionSet selectionSet) {
        Map<Long, List<BookGenreProjection>> genreMap = new HashMap<>();
        boolean fillGenres = selectionSet.contains("genres");
        boolean fillAuthor = selectionSet.contains("author");
        if (fillGenres) {
            genreMap = genreRepository.findByBooks(page.toList()).stream()
                    .collect(Collectors.groupingBy(BookGenreProjection::bookId));
        }
        List<Book> dtoList = new ArrayList<>();
        for (BookEntity book : page) {
            Book dto = new Book()
                    .setId(book.getId())
                    .setName(book.getName())
                    .setPageCount(book.getPageCount());
            if (fillAuthor) {
                Author authorDto = authorMapper.toDto(book.getAuthor());
                dto.setAuthor(authorDto);
            }
            if (fillGenres) {
                List<BookGenreProjection> genresInfo = genreMap.get(book.getId());
                List<Genre> genreDtoList = genreMapper.toDtoListFromProjections(genresInfo);
                dto.setGenres(genreDtoList);
            }
            dtoList.add(dto);
        }
        return dtoList;
    }

    private List<GenreEntity> getGenres(BookEntity book) {
        return book.getGenreRelations().stream()
                .map(BookGenreRelationEntity::getGenre)
                .toList();
    }
}
