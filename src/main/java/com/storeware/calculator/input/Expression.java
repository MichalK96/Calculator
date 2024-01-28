package com.storeware.calculator.input;

import com.storeware.calculator.core.ArithmeticOperator;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Expression {

    private final double number;
    private final ArithmeticOperator arithmeticOperator;

    public boolean isStartExpression() {
     return arithmeticOperator == null;
    }
}
