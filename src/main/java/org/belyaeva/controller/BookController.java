package org.belyaeva.controller;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import org.belyaeva.dto.Book;
import org.belyaeva.dto.BookFilter;
import org.belyaeva.dto.NewBook;
import org.belyaeva.service.book.api.BookPublisher;
import org.belyaeva.service.book.api.BookService;
import org.slf4j.Logger;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
public class BookController {

    private static final Logger LOGGER = getLogger(BookController.class);

    private final BookPublisher bookPublisher;
    private final BookService bookService;

    public BookController(BookPublisher bookPublisher,
                          BookService bookService) {
        this.bookPublisher = bookPublisher;
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
        Long bookId = bookService.addNewBook(book);
        bookPublisher.publish(this.getBookById(bookId));
        return bookId;
    }

    @SubscriptionMapping
    public Flux<Book> getMockBooksEverySecond() {
        LOGGER.debug("Subscription Mock Books EverySecond");
        return Flux.interval(Duration.ofSeconds(1))
                .map(num -> {
                    Book book = new Book().setId(num).setName("Dune " + num).setPageCount(1000);
                    LOGGER.debug("New event of creation Mock Book {}", book);
                    return book;
                });
    }

    @SubscriptionMapping
    public Flux<Book> getNewBooksInRealTime() {
        LOGGER.debug("Subscription New Books");
        return bookPublisher.flux();
    }
}
