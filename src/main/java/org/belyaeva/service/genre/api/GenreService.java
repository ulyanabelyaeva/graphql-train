package org.belyaeva.service.genre.api;

import org.belyaeva.dto.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getByIds(List<Long> ids);
}
