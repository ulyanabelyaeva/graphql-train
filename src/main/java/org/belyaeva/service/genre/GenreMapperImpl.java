package org.belyaeva.service.genre;

import org.belyaeva.dto.Genre;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.entity.projection.BookGenreProjection;
import org.belyaeva.service.genre.api.GenreMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Component
public class GenreMapperImpl implements GenreMapper {

    @Override
    public List<Genre> toDtoList(List<GenreEntity> genres) {
        if (isNull(genres) || genres.isEmpty()) {
            return new ArrayList<>();
        }
        return genres.stream()
                .map(genre -> new Genre().setId(genre.getId())
                        .setName(genre.getName()))
                .toList();
    }

    @Override
    public List<Genre> toDtoListFromProjections(List<BookGenreProjection> genres) {
        if (isNull(genres) || genres.isEmpty()) {
            return new ArrayList<>();
        }
        return genres.stream()
                .map(genre -> new Genre().setId(genre.genreId())
                        .setName(genre.genreName()))
                .toList();
    }
}
