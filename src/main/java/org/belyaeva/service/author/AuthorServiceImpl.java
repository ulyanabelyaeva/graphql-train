package org.belyaeva.service.author;

import org.belyaeva.dto.Author;
import org.belyaeva.entity.AuthorEntity;
import org.belyaeva.repository.AuthorRepository;
import org.belyaeva.service.author.api.AuthorMapper;
import org.belyaeva.service.author.api.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Author> getById(Long id) {
        Optional<AuthorEntity> authorOptional = authorRepository.findById(id);
        return authorMapper.toDto(authorOptional);
    }
}
