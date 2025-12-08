package org.belyaeva.service.book.api;

import graphql.schema.DataFetchingFieldSelectionSet;
import org.belyaeva.dto.BookFilter;
import org.belyaeva.entity.BookEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface BookSearchHelper {

    Specification<BookEntity> createSpecification(BookFilter request, DataFetchingFieldSelectionSet selectionSet);

    Pageable createPageable(BookFilter request);
}
