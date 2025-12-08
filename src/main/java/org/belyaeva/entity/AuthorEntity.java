package org.belyaeva.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public AuthorEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
