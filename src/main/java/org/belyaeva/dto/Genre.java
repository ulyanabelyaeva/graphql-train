package org.belyaeva.dto;

import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

public class Genre {

    private Long id;
    private String name;

    public Genre() {
    }

    public Genre(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Genre> genres = Arrays.asList(
            new Genre(1L, "Fantasy"),
            new Genre(2L, "Horror"),
            new Genre(3L, "Drama")
    );

    public static List<Genre> getGenreByIds(List<Long> ids) {
        if (isNull(ids) || ids.isEmpty()) {
            return null;
        }
        return genres.stream()
                .filter(genre -> ids.contains(genre.id))
                .toList();
    }

    public static List<Genre> getByFilter(GenreFilter request) {
        return genres;
    }

    public Long getId() {
        return id;
    }

    public Genre setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Genre setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
