package org.belyaeva.service.author.api;

import org.belyaeva.dto.Author;
import org.belyaeva.entity.AuthorEntity;

import java.util.Optional;

public interface AuthorMapper {

    Optional<Author> toDto(Optional<AuthorEntity> author);
}
