package com.storeware.calculator.calculator;

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
            case "add" -> {
                return result + num;
            }
            case "subtract" -> {
                return result - num;
            }
            case "multiply" -> {
                return result * num;
            }
            case "divide" -> {
                if (num == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return result / num;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        }
    }

}
