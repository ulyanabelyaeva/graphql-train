package org.belyaeva.service.book;

import graphql.schema.DataFetchingFieldSelectionSet;
import jakarta.persistence.criteria.Fetch;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.belyaeva.dto.BookFilter;
import org.belyaeva.dto.basic.FieldFilter;
import org.belyaeva.entity.AuthorEntity;
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
    public Specification<BookEntity> createSpecification(BookFilter request,
                                                         DataFetchingFieldSelectionSet selectionSet) {
        Specification<BookEntity> base = (root, query, cb) -> query.distinct(true).getRestriction();
        if (selectionSet.contains("author")) {
            base = base.and(this.fetchAuthor());
        }
        return base.and(this.addFilterByName(request.getName()))
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

    private Specification<BookEntity> fetchAuthor() {
        return (root, query, builder) -> {
            Fetch<BookEntity, AuthorEntity> fetch = root.fetch(BookEntity_.author, JoinType.LEFT);
            return ((Join<BookEntity, AuthorEntity>) fetch).getOn();
        };
    }
}
