package org.belyaeva.service.author;

import org.belyaeva.dto.Author;
import org.belyaeva.entity.AuthorEntity;
import org.belyaeva.service.author.api.AuthorMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    @Transactional(propagation = MANDATORY)
    public Optional<Author> toDto(Optional<AuthorEntity> author) {
        return author
                .map(a -> new Author(a.getId(), a.getName()))
                .or(Optional::empty);
    }
}
