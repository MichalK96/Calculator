package com.storeware.calculator.core;

class MultiplyOperation implements Operation {


    @Override
    public double performOperation(double a, double b) {
        return a * b;
    }
}
