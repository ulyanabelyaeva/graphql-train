package org.belyaeva.controller;

import org.belyaeva.dto.*;
import org.belyaeva.service.author.api.AuthorService;
import org.belyaeva.service.book.api.BookService;
import org.belyaeva.service.genre.api.GenreService;
import org.slf4j.Logger;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class BookController {

    private static final Logger LOGGER = getLogger(BookController.class);

    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;

    public BookController(AuthorService authorService,
                          GenreService genreService,
                          BookService bookService) {
        this.authorService = authorService;
        this.genreService = genreService;
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> getAllBooks(@Argument BookFilter filter) {
        LOGGER.info("Querying Books: {}", filter);
        return bookService.getAllBooks(filter);
    }

    @QueryMapping
    public Book getBookById(@Argument Long id) {
        LOGGER.info("Querying Books by ID {}", id);
        return bookService.getBookById(id);
    }

    @SchemaMapping
    public Optional<Author> author(Book book) {
        LOGGER.debug("Querying Author by Book {}", book.getId());
        return authorService.getById(book.getAuthorId());
    }

    @SchemaMapping
    public List<Genre> genres(Book book) {
        LOGGER.debug("Querying Genres by Book {}", book.getId());
        return genreService.getByIds(book.getGenreIds());
    }

    @MutationMapping
    public Long createNewBook(@Argument NewBook book) {
        LOGGER.debug("Creating new Book {}", book);
        return bookService.addNewBook(book);
    }
}
