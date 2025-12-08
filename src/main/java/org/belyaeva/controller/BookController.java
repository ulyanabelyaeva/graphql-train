package org.belyaeva.controller;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.belyaeva.dto.Book;
import org.belyaeva.dto.BookFilter;
import org.belyaeva.dto.NewBook;
import org.belyaeva.service.book.api.BookService;
import org.slf4j.Logger;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class BookController {

    private static final Logger LOGGER = getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> getAllBooks(@Argument BookFilter filter,
                                  DataFetchingEnvironment env) {
        DataFetchingFieldSelectionSet selectionSet = env.getSelectionSet();
        LOGGER.info("Querying Books: {}", filter);
        return bookService.getAllBooks(filter, selectionSet);
    }

    @QueryMapping
    public Book getBookById(@Argument Long id) {
        LOGGER.info("Querying Books by ID {}", id);
        return bookService.getBookById(id);
    }

    @MutationMapping
    public Long createNewBook(@Argument NewBook book) {
        LOGGER.debug("Creating new Book {}", book);
        return bookService.addNewBook(book);
    }
}
