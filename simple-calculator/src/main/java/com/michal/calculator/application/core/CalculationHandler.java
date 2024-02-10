package com.michal.calculator.application.core;

import com.michal.calculator.infrastructure.Expression;

import java.math.BigDecimal;
import java.util.List;

class CalculationHandler {

    BigDecimal count(List<Expression> inputData) {
        var result = getFirstNumber(inputData);
        for (Expression expression : inputData) {
            if (!expression.isStartExpression()) {
                result = ArithmeticOperator.valueOf(expression.getOperator().name()).performOperation(result, expression.getNumber());
            }
        }
        return result.stripTrailingZeros();
    }

    private BigDecimal getFirstNumber(List<Expression> inputData) {
        var startValue = inputData.stream()
                .filter(Expression::isStartExpression)
                .findAny();
        if (startValue.isPresent()) {
            return startValue.get().getNumber();
        }
        throw new IllegalArgumentException("No start expression found");
    }
}
