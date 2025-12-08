package org.belyaeva.service.genre.api;

import org.belyaeva.dto.Genre;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.entity.projection.BookGenreProjection;

import java.util.List;

public interface GenreMapper {

    List<Genre> toDtoList(List<GenreEntity> genres);

    List<Genre> toDtoListFromProjections(List<BookGenreProjection> genres);
}
