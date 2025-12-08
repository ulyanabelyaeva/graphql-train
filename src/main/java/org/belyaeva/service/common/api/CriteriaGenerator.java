package org.belyaeva.service.common.api;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.belyaeva.dto.basic.FieldFilter;

public interface CriteriaGenerator {

    Predicate generateCriteria(CriteriaBuilder cb,
                               Root<?> root,
                               String innerField,
                               FieldFilter filter);
}
