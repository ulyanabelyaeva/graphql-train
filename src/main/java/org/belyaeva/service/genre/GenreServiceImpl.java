package org.belyaeva.service.genre;

import org.belyaeva.dto.Genre;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.repository.GenreRepository;
import org.belyaeva.service.genre.api.GenreMapper;
import org.belyaeva.service.genre.api.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreServiceImpl(GenreRepository genreRepository,
                            GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public List<Genre> getByIds(List<Long> ids) {
        List<GenreEntity> genres = genreRepository.findAllById(ids);
        return genreMapper.toDtoList(genres);
    }
}
