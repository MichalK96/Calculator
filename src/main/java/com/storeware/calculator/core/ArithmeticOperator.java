package com.storeware.calculator.core;

public enum ArithmeticOperator {

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

}
