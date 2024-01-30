package com.storeware.calculator.core;

class SubtractOperation implements Operation {


    @Override
    public double performOperation(double a, double b) {
        return a - b;
    }
}
