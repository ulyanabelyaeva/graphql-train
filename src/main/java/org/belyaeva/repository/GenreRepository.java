package org.belyaeva.repository;

import org.belyaeva.entity.BookEntity;
import org.belyaeva.entity.GenreEntity;
import org.belyaeva.entity.projection.BookGenreProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

    @Query("""
            select new org.belyaeva.entity.projection.BookGenreProjection(b.id, g.id, g.name)
            from GenreEntity g
            inner join BookGenreRelationEntity bgr on g.id = bgr.genre.id
            inner join BookEntity b on b.id = bgr.book.id
            where b in :books
            """)
    List<BookGenreProjection> findByBooks(@Param("books") List<BookEntity> books);
}
