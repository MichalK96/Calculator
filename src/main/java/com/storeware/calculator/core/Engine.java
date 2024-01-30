package com.storeware.calculator.core;

import com.storeware.calculator.CalculatorResources;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

public class Engine {

    private final CalculatorResources resources;
    private List<Expression> inputData;

    public Engine(CalculatorResources resources) {
        this.resources = resources;
    }

    public void run() {
        inputData = resources.getInputHandler().readInput();
        validateInputData();

        var result = count();
        resources.getOutputHandler().handleResult(result);
    }

    private void validateInputData() {
        var numStartExpression = inputData.stream()
                .filter(Expression::isStartExpression)
                .count();
        if (numStartExpression != 1) {
            throw new IllegalArgumentException("Number of apply form is different than one");
        }
    }

    private double count() {
        double result = 0;
        for (Expression expression : inputData) {
            result += expression.getArithmeticOperator().performOperation(result, expression.getNumber());
        }
        return result;
    }

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



    public double add(double result, double number) {
        return result + number;
    }

    public double subtract(double result, double number) {
        return result - number;
    }

    public double multiply(double result, double number) {
        return result * number;
    }

    public double divide(double result, double number) {
        if (number == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return result / number;
    }

}
