package org.belyaeva.service.common.api;

import org.belyaeva.dto.basic.FieldFilter;
import org.springframework.data.jpa.domain.Specification;

public interface CriteriaGenerator<E> {

    Specification<E> generateCriteria(String innerField,
                                      FieldFilter filter);
}
