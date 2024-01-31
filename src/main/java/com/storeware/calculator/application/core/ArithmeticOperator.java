package com.storeware.calculator.application.core;

enum ArithmeticOperator {

    ADD(new AddOperation()),
    SUBTRACT(new SubtractOperation()),
    MULTIPLY(new MultiplyOperation()),
    DIVIDE(new DevideOperation());

    private final Operation operation;

    ArithmeticOperator(Operation operation) {
        this.operation = operation;
    }

    public double performOperation(double a, double b) {
        return operation.performOperation(a, b);
    }

    private interface Operation {
        double performOperation(double a, double b);
    }

    private static class AddOperation implements Operation {
        @Override
        public double performOperation(double a, double b) {
            return a + b;
        }

    }

    private static class MultiplyOperation implements Operation {
        @Override
        public double performOperation(double a, double b) {
            return a * b;
        }
    }

    private static class SubtractOperation implements Operation {
        @Override
        public double performOperation(double a, double b) {
            return a - b;
        }
    }

    private static class DevideOperation implements Operation {
        @Override
        public double performOperation(double a, double b) {
            if (b == 0) {
                throw new IllegalArgumentException("Cannot divide by zero");
            }
            return a / b;
        }
    }
}
