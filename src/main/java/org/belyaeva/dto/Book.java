package org.belyaeva.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record Book(Integer id,
                   String name,
                   Integer pageCount,
                   Integer authorId) {

    public static List<Book> books = Arrays.asList(
            new Book(1, "Harry Potter", 1030, 1),
            new Book(2, "Foo", 300, 2),
            new Book(3, "Game of Thrones", 5600, 1),
            new Book(4, "Spring in Action", 2000, 2)
    );

    public static Optional<Book> getById(Integer id) {
        return books.stream()
                .filter(b -> Objects.equals(b.id, id))
                .findFirst();
    }
}
