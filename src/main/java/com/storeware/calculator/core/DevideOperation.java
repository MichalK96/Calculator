package com.storeware.calculator.core;

class DevideOperation implements Operation {

    @Override
    public double performOperation(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

}
