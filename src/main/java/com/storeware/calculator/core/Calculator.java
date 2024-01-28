package com.storeware.calculator.core;

import java.util.List;

public class Calculator {


    public int calculateSetOfOperations(List<String> mathematicalOperations) {
        if (mathematicalOperations.isEmpty()) {
            throw new IllegalArgumentException("No Operations provided");
        }
        int result = CalculatorUtils.getNumber(mathematicalOperations.get(mathematicalOperations.size() - 1));
        for (int i = 0; i < mathematicalOperations.size() - 1; i++) {
            String expression = mathematicalOperations.get(i);
            result = calculateOperation(result, expression);
        }
        return result;
    }

    int calculateOperation(int result, String expression) {
        int num = CalculatorUtils.getNumber(expression);
        switch (CalculatorUtils.getOperator(expression)) {
            case ADD -> {
                return result + num;
            }
            case SUBTRACT -> {
                return result - num;
            }
            case MULTIPLY -> {
                return result * num;
            }
            case DIVIDE -> {
                if (num == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return result / num;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        }
    }

}
