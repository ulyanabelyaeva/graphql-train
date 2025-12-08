package org.belyaeva.service.author.api;

import org.belyaeva.dto.Author;
import org.belyaeva.entity.AuthorEntity;

public interface AuthorMapper {

    Author toDto(AuthorEntity author);
}
