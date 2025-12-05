package org.belyaeva.dto;

public class FieldFilter {

    private String operator;
    private String value;

    public String getOperator() {
        return operator;
    }

    public FieldFilter setOperator(String operator) {
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
