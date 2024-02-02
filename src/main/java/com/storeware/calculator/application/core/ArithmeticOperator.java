package com.storeware.calculator.application.core;

import com.storeware.calculator.application.core.exception.DivideByZeroException;

import java.math.BigDecimal;
import java.math.RoundingMode;

enum ArithmeticOperator {

    ADD(new AddOperation()),
    SUBTRACT(new SubtractOperation()),
    MULTIPLY(new MultiplyOperation()),
    DIVIDE(new DevideOperation());

    private final Operation operation;

    ArithmeticOperator(Operation operation) {
        this.operation = operation;
    }

    public BigDecimal performOperation(BigDecimal a, BigDecimal b) {
        return operation.performOperation(a, b);
    }

    private interface Operation {
        BigDecimal performOperation(BigDecimal a, BigDecimal b);
    }

    private static class AddOperation implements Operation {
        @Override
        public BigDecimal performOperation(BigDecimal a, BigDecimal b) {
            return a.add(b);
        }

    }

    private static class MultiplyOperation implements Operation {
        @Override
        public BigDecimal performOperation(BigDecimal a, BigDecimal b) {
            return a.multiply(b);
        }
    }

    private static class SubtractOperation implements Operation {
        @Override
        public BigDecimal performOperation(BigDecimal a, BigDecimal b) {
            return a.subtract(b);
        }
    }

    private static class DevideOperation implements Operation {
        @Override
        public BigDecimal performOperation(BigDecimal a, BigDecimal b) {
            if (b.compareTo(BigDecimal.ZERO) == 0) {
                throw new DivideByZeroException("You can not divide by zero");
            }
            return a.divide(b, 10, RoundingMode.HALF_UP);   // TODO move scale and RoundingMode to calculator configuration
        }
    }
}
