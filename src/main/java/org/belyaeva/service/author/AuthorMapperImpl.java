package org.belyaeva.service.author;

import org.belyaeva.dto.Author;
import org.belyaeva.entity.AuthorEntity;
import org.belyaeva.service.author.api.AuthorMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.isNull;
import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    @Transactional(propagation = MANDATORY)
    public Author toDto(AuthorEntity author) {
        if (isNull(author)) {
            return null;
        }
        return new Author(author.getId(), author.getName());
    }
}
