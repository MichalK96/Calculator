package com.storeware.calculator.infrastructure;

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
}
