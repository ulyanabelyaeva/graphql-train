package org.belyaeva.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "genre")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public GenreEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public GenreEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
