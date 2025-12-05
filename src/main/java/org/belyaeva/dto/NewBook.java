package org.belyaeva.dto;

import java.util.ArrayList;
import java.util.List;

public class NewBook {

    private String name;
    private Integer pageCount;
    private List<Long> genreIds = new ArrayList<>();

    public String getName() {
        return name;
    }

    public NewBook setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public NewBook setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public List<Long> getGenreIds() {
        return genreIds;
    }

    public NewBook setGenreIds(List<Long> genreIds) {
        this.genreIds = genreIds;
        return this;
    }

    @Override
    public String toString() {
        return "NewBook{" +
                "name='" + name + '\'' +
                ", pageCount=" + pageCount +
                ", genreIds=" + genreIds +
                '}';
    }
}
