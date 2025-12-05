package org.belyaeva.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Author {

    private Long id;
    private String name;

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Author> authors = Arrays.asList(
            new Author(1L, "Chekhov"),
            new Author(2L, "Dostoevsky"),
            new Author(3L, "Pushkin")
    );

    public static Author getAuthorById(Long id) {
        if (isNull(id)) {
            return null;
        }
        return authors.stream()
                .filter(a -> Objects.equals(a.id, id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Author was not found by id " + id));
    }

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
