package org.belyaeva.service.author.api;

import org.belyaeva.dto.Author;

import java.util.Optional;

public interface AuthorService {

    Optional<Author> getById(Long id);
}
