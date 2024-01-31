package com.storeware.calculator.infrastructure;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Expression {

    private final double number;
    private final Operator operator;

    public boolean isStartExpression() {
     return operator.equals(Operator.APPLY);
    }
}
