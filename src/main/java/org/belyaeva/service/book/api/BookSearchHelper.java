package org.belyaeva.service.book.api;

import org.belyaeva.dto.BookFilter;
import org.belyaeva.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BookSearchHelper {

    Specification<BookEntity> createSpecification(BookFilter request);

    Pageable createPageable(BookFilter request);
}
