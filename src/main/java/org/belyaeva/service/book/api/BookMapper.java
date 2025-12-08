package org.belyaeva.service.book.api;

import org.belyaeva.dto.Book;
import org.belyaeva.entity.BookEntity;

public interface BookMapper {

    Book toDto(BookEntity book);
}
