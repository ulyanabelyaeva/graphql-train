package org.belyaeva.service.genre.api;

import org.belyaeva.dto.Genre;
import org.belyaeva.entity.GenreEntity;

import java.util.List;

public interface GenreMapper {

    List<Genre> toDtoList(List<GenreEntity> genres);
}
