package org.belyaeva.service.book;

import org.belyaeva.dto.Book;
import org.belyaeva.entity.BookEntity;
import org.belyaeva.entity.BookGenreRelationEntity;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.service.book.api.BookMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    @Transactional(propagation = MANDATORY)
    public Book toDto(BookEntity book) {
        List<Long> genreIds = book.getGenreRelations().stream()
                .map(BookGenreRelationEntity::getGenre)
                .map(GenreEntity::getId)
                .toList();
        return new Book()
                .setId(book.getId())
                .setName(book.getName())
                .setPageCount(book.getPageCount())
                .setAuthorId(book.getAuthor().getId())
                .setGenreIds(genreIds);
    }
}
