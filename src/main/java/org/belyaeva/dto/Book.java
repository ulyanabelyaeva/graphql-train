package org.belyaeva.dto;

import java.util.List;

public class Book {

    private Long id;
    private String name;
    private Integer pageCount;
    private Long authorId;
    private List<Long> genreIds;

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
