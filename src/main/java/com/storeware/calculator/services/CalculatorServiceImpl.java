package com.storeware.calculator.services;

public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public double add(double result, double number) {
        return result + number;
    }

    @Override
    public double subtract(double result, double number) {
        return result - number;
    }

    @Override
    public double multiply(double result, double number) {
        return result * number;
    }

    @Override
    public double divide(double result, double number) {
        if (number == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return result / number;
    }
}
