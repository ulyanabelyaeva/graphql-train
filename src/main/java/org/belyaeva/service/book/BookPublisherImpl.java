package org.belyaeva.service.book;

import org.belyaeva.dto.Book;
import org.belyaeva.service.book.api.BookPublisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Component
public class BookPublisherImpl implements BookPublisher {

    private final Sinks.Many<Book> sink = Sinks.many().multicast().onBackpressureBuffer();

    @Override
    public void publish(Book book) {
        sink.tryEmitNext(book);
    }

    @Override
    public Flux<Book> flux() {
        return sink.asFlux();
    }
}
