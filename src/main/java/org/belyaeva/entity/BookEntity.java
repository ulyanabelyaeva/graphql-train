package org.belyaeva.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "page_count", nullable = false)
    private Integer pageCount;

    @ManyToOne(fetch = FetchType.LAZY)
    private AuthorEntity author;

    @OneToMany(mappedBy = "book", cascade = ALL)
    private List<BookGenreRelationEntity> genreRelations = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public BookEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BookEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public BookEntity setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
        return this;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public BookEntity setAuthor(AuthorEntity author) {
        this.author = author;
        return this;
    }

    public List<BookGenreRelationEntity> getGenreRelations() {
        return genreRelations;
    }

    public BookEntity setGenreRelations(List<BookGenreRelationEntity> genreRelations) {
        this.genreRelations = genreRelations;
        return this;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pageCount=" + pageCount +
                ", author.id=" + author.getId() +
                '}';
    }
}
