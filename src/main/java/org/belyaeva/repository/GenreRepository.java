package org.belyaeva.repository;

import org.belyaeva.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
}
