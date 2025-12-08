package org.belyaeva.service.book.api;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.belyaeva.dto.Book;
import org.belyaeva.entity.BookEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookMapper {

    Book toDto(BookEntity book);

    List<Book> toDtoList(Page<BookEntity> page,
                         DataFetchingFieldSelectionSet selectionSet);
}
