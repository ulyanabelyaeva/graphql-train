package org.belyaeva.controller;

import org.belyaeva.dto.Author;
import org.belyaeva.dto.Book;
import org.belyaeva.dto.Genre;
import org.belyaeva.dto.NewBook;
import org.slf4j.Logger;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class BookController {

    private final Logger LOGGER = getLogger(BookController.class);

    @QueryMapping
    public List<Book> getAllBooks() {
        LOGGER.info("Querying Books");
        return Book.books;
    }

    @QueryMapping
    public Book getBookById(@Argument Long id) {
        LOGGER.info("Querying Books by ID {}", id);
        return Book.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        LOGGER.debug("Querying Author by Book {}", book.getId());
        return Author.getAuthorById(book.getAuthorId());
    }

    @SchemaMapping
    public List<Genre> genres(Book book) {
        LOGGER.debug("Querying Genres by Book {}", book.getId());
        return Genre.getGenreByIds(book.getGenreIds());
    }

    @MutationMapping
    public Long createNewBook(@Argument NewBook book) {
        LOGGER.debug("Creating new Book {}", book);
        return Book.addNewBook(book);
    }
}
