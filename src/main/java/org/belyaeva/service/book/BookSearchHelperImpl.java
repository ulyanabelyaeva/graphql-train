package org.belyaeva.service.book;

import org.belyaeva.dto.BookFilter;
import org.belyaeva.dto.basic.FieldFilter;
import org.belyaeva.entity.BookEntity;
import org.belyaeva.entity.BookEntity_;
import org.belyaeva.service.book.api.BookSearchHelper;
import org.belyaeva.service.common.api.CriteriaGenerator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BookSearchHelperImpl implements BookSearchHelper {

    private final CriteriaGenerator criteriaGenerator;

    public BookSearchHelperImpl(CriteriaGenerator criteriaGenerator) {
        this.criteriaGenerator = criteriaGenerator;
    }

    @Override
    public Specification<BookEntity> createSpecification(BookFilter request) {
        return this.addFilterByName(request.getName())
                .and(this.addFilterByName(request.getName()))
                .and(this.addFilterByPageCount(request.getPageCount()));
    }

    @Override
    public Pageable createPageable(BookFilter request) {
        return PageRequest.of(request.getPageNumber(), request.getPageSize());
    }

    private Specification<BookEntity> addFilterByName(FieldFilter filter) {
        return (root, query, builder) -> criteriaGenerator.generateCriteria(builder, root, BookEntity_.NAME, filter);
    }

    private Specification<BookEntity> addFilterByPageCount(FieldFilter filter) {
        return (root, query, builder) -> criteriaGenerator.generateCriteria(builder, root, BookEntity_.PAGE_COUNT, filter);
    }
}
