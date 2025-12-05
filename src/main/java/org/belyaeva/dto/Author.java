package org.belyaeva.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public record Author(Integer id,
                     String name) {

    public static List<Author> authors = Arrays.asList(
            new Author(1, "Chekhov"),
            new Author(2, "Dostoevsky"),
            new Author(3, "Pushkin")
    );

    public static Optional<Author> getAuthorById(Integer id) {
        return authors.stream()
                .filter(a -> Objects.equals(a.id, id))
                .findFirst();
    }
}
