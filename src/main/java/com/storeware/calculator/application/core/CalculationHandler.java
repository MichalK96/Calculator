package com.storeware.calculator.application.core;

import com.storeware.calculator.infrastructure.Expression;
import com.sun.jdi.connect.Connector;

import java.util.List;
import java.util.Objects;

class CalculationHandler {

    double count(List<Expression> inputData) {
        double result = getFirstNumber(inputData);
        for (Expression expression : inputData) {
            if (!expression.isStartExpression()) {
                result = ArithmeticOperator.valueOf(expression.getOperator().name()).performOperation(result, expression.getNumber());
            }
        }
        return result;
    }

    private double getFirstNumber(List<Expression> inputData) {
        var startValue = inputData.stream()
                .filter(Expression::isStartExpression)
                .findAny();
        if (startValue.isPresent()) {
            return startValue.get().getNumber();
        }
        throw new IllegalArgumentException("No start expression found");
    }

}
