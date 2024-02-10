package com.michal.calculator.infrastructure;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Expression {

    private final BigDecimal number;
    private final Operator operator;

    public boolean isStartExpression() {
     return operator.equals(Operator.APPLY);
    }

    public boolean isEndExpression() {
        return operator.equals(Operator.DONE);
    }
}
