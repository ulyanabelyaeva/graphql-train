package org.belyaeva.dto.basic;

public class FieldFilter {

    private FilterOperator operator;
    private String value;

    public FilterOperator getOperator() {
        return operator;
    }

    public FieldFilter setOperator(FilterOperator operator) {
        this.operator = operator;
        return this;
    }

    public String getValue() {
        return value;
    }

    public FieldFilter setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "FieldFilter{" +
                "operator='" + operator + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
