package org.belyaeva.service.book.api;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.belyaeva.dto.Book;
import org.belyaeva.dto.BookFilter;
import org.belyaeva.dto.NewBook;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks(BookFilter request,
                           DataFetchingFieldSelectionSet selectionSet);

    Book getBookById(long id);

    Long addNewBook(NewBook request);
}
