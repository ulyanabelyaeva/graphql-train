package org.belyaeva.service.book.api;

import org.belyaeva.dto.Book;
import reactor.core.publisher.Flux;

public interface BookPublisher {

    void publish(Book book);

    Flux<Book> flux();
}
