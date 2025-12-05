package org.belyaeva.dto;

import java.util.*;

public class Book {

    private Long id;
    private String name;
    private Integer pageCount;
    private Long authorId;
    private List<Long> genreIds;

    public Book(Long id, String name, Integer pageCount, Long authorId, List<Long> genreIds) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.authorId = authorId;
        this.genreIds = genreIds;
    }

    public static List<Book> books = new ArrayList<>(List.of(
            new Book(1L, "Harry Potter", 1030, 1L, List.of(1L)),
            new Book(2L, "Foo", 300, 2L, List.of()),
            new Book(3L, "Game of Thrones", 5600, 1L, List.of(2L)),
            new Book(4L, "Spring in Action", 2000, 2L, List.of(1L, 2L))
    ));

    public static Book getById(Long id) {
        return books.stream()
                .filter(b -> Objects.equals(b.id, id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Book was not found by " + id));
    }

    public static Long addNewBook(NewBook request) {
        long newId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        List<Long> existedGenres = Genre.genres.stream().map(Genre::getId).toList();
        List<Long> availableGenreIds = request.getGenreIds().stream().filter(existedGenres::contains).toList();
        books.add(new Book(newId, request.getName(), request.getPageCount(), null, availableGenreIds));
        return newId;
    }

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public Book setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Book setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public Book setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pageCount=" + pageCount +
                ", authorId=" + authorId +
                ", genreIds=" + genreIds +
                '}';
    }
}
