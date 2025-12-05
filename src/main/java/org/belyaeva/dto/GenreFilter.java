package org.belyaeva.dto;

public class GenreFilter {

    private FieldFilter name;
    private FieldFilter bookCount;

    public FieldFilter getName() {
        return name;
    }

    public GenreFilter setName(FieldFilter name) {
        this.name = name;
        return this;
    }

    public FieldFilter getBookCount() {
        return bookCount;
    }

    public GenreFilter setBookCount(FieldFilter bookCount) {
        this.bookCount = bookCount;
        return this;
    }

    @Override
    public String toString() {
        return "GenreFilter{" +
                "name=" + name +
                ", bookCount=" + bookCount +
                '}';
    }
}
