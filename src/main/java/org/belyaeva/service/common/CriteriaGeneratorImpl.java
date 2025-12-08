package org.belyaeva.service.common;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.belyaeva.dto.basic.FieldFilter;
import org.belyaeva.dto.basic.FilterOperator;
import org.belyaeva.service.common.api.CriteriaGenerator;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
public class CriteriaGeneratorImpl implements CriteriaGenerator {

    @Override
    public Predicate generateCriteria(CriteriaBuilder cb,
                                      Root<?> root,
                                      String innerField,
                                      FieldFilter filter) {
        if (isNull(filter)) {
            return cb.conjunction();
        }
        String value = filter.getValue();
        FilterOperator operator = filter.getOperator();
        try {
            int v = Integer.parseInt(value);
            Path<Number> expression = root.get(innerField);
            switch (operator) {
                case LT -> cb.lt(expression, v);
                case LE ->  cb.le(expression, v);
                case GT -> cb.gt(expression, v);
                case GE ->  cb.ge(expression, v);
                case EQ ->  cb.equal(expression, v);
            }
        } catch (NumberFormatException e) {
            Path<String> expression = root.get(innerField);
            switch (operator) {
                case CONTAINS ->  cb.like(expression, "%" + value + "%");
                case EQ ->  cb.equal(expression, value);
            }
        }
        return null;
    }
}
