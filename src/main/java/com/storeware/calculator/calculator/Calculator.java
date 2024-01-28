package com.storeware.calculator.calculator;

import java.util.List;

public class Calculator {


    public int calculateSetOfOperations(List<String> mathematicalOperations) {
        if (mathematicalOperations.isEmpty()) {
            throw new IllegalArgumentException("No Operations provided");
        }
        int number = CalculatorUtils.getNumber(mathematicalOperations.get(mathematicalOperations.size() - 1));
        for (int i = 0; i < mathematicalOperations.size() - 1; i++) {
            String expression = mathematicalOperations.get(i);
            number = calculateOperation(number, expression);
        }
        return number;
    }

    int calculateOperation(int number, String expression) {
        int num = CalculatorUtils.getNumber(expression);
        switch (CalculatorUtils.getOperator(expression)) {
            case ADD -> {
                return number + num;
            }
            case SUBTRACT -> {
                return number - num;
            }
            case MULTIPLY -> {
                return number * num;
            }
            case DIVIDE -> {
                if (num == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return number / num;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        }
    }

}
