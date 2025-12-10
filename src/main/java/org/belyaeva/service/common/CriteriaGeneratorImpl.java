package org.belyaeva.service.common;

import jakarta.persistence.criteria.Path;
import org.belyaeva.dto.basic.FieldFilter;
import org.belyaeva.dto.basic.FilterOperator;
import org.belyaeva.service.common.api.CriteriaGenerator;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class CriteriaGeneratorImpl<E> implements CriteriaGenerator<E> {

    @Override
    public Specification<E> generateCriteria(String innerField,
                                             FieldFilter filter) {
        if (isNull(filter)) {
            return null;
        }
        String value = filter.getValue();
        FilterOperator operator = filter.getOperator();
        return (r, q, cb) -> {
            try {
                int v = Integer.parseInt(value);
                Path<Number> expression = r.get(innerField);
                return switch (operator) {
                    case LT -> cb.lt(expression, v);
                    case LE -> cb.le(expression, v);
                    case GT -> cb.gt(expression, v);
                    case GE -> cb.ge(expression, v);
                    case EQ -> cb.equal(expression, v);
                    default -> null;
                };
            } catch (NumberFormatException e) {
                Path<String> expression = r.get(innerField);
                return switch (operator) {
                    case CONTAINS -> cb.like(expression, "%" + value + "%");
                    case EQ -> cb.equal(expression, value);
                    default -> null;
                };
            }
        };
    }
}
