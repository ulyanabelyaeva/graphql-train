package org.belyaeva.service.genre;

import org.belyaeva.dto.Genre;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.service.genre.api.GenreMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public List<Genre> toDtoList(List<GenreEntity> genres) {
        return genres.stream()
                .map(genre -> new Genre(genre.getId(), genre.getName()))
                .toList();
    }
}
