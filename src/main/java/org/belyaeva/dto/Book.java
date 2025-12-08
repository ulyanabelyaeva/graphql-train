package org.belyaeva.dto;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Long id;
    private String name;
    private Integer pageCount;
    private Author author;
    private List<Genre> genres = new ArrayList<>();

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

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public Book setGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                ", genres=" + genres +
                '}';
    }
}
