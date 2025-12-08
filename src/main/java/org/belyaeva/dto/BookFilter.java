package org.belyaeva.dto;

import org.belyaeva.dto.basic.FieldFilter;

public class BookFilter {

    private FieldFilter name;
    private FieldFilter pageCount;
    private FieldFilter authorName;
    private FieldFilter genreName;

    private Integer pageNumber;
    private Integer pageSize;

    public FieldFilter getName() {
        return name;
    }

    public BookFilter setName(FieldFilter name) {
        this.name = name;
        return this;
    }

    public FieldFilter getPageCount() {
        return pageCount;
    }

    public BookFilter setPageCount(FieldFilter pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public FieldFilter getAuthorName() {
        return authorName;
    }

    public BookFilter setAuthorName(FieldFilter authorName) {
        this.authorName = authorName;
        return this;
    }

    public FieldFilter getGenreName() {
        return genreName;
    }

    public BookFilter setGenreName(FieldFilter genreName) {
        this.genreName = genreName;
        return this;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public BookFilter setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public BookFilter setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    @Override
    public String toString() {
        return "BookFilter{" +
                "name=" + name +
                ", pageCount=" + pageCount +
                ", authorName=" + authorName +
                ", genreName=" + genreName +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
