package org.belyaeva.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_genre_relation")
public class BookGenreRelationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private BookEntity book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;

    public Long getId() {
        return id;
    }

    public BookGenreRelationEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public BookEntity getBook() {
        return book;
    }

    public BookGenreRelationEntity setBook(BookEntity book) {
        this.book = book;
        return this;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public BookGenreRelationEntity setGenre(GenreEntity genre) {
        this.genre = genre;
        return this;
    }

    @Override
    public String toString() {
        return "BookGenreRelationEntity{" +
                "id=" + id +
                ", book.id=" + book.getId() +
                ", genre.id=" + genre.getId() +
                '}';
    }
}
