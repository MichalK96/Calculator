package com.storeware.calculator.input;

import com.storeware.calculator.core.ArithmeticOperator;

class LineExpressionConverter {

    private static final String startExpressionWord = "apply";

    private LineExpressionConverter() {
        throw new IllegalStateException("Utility class");
    }

    static Expression createExpression(String lineExpression) {
        return Expression.builder()
                .number(getNumber(lineExpression))
                .arithmeticOperator(getOperator(lineExpression))
                .build();
    }

    private static int getNumber(String expression) {
        StringBuilder output = new StringBuilder();
        for (int i = expression.length() - 1;i >= 0; i--) {
            if (Character.isDigit(expression.charAt(i))) {
                output.append(expression.charAt(i));
            } else {
                if (output.isEmpty()) {
                    throw new IllegalArgumentException("No number provided");
                }
                break;
            }
        }
        output.reverse();
        return Integer.parseInt(String.valueOf(output));
    }

    private static ArithmeticOperator getOperator(String expression) {
        StringBuilder operator = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isLetter(expression.charAt(i))) {
                operator.append(expression.charAt(i));
            } else {
                if (operator.isEmpty()) {
                    throw new IllegalArgumentException("No operator provided");
                } else if (isStartExpression(expression)) {
                    return null;
                }
                break;
            }
        }
        try {
            return ArithmeticOperator.valueOf(operator.toString().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static boolean isStartExpression(String expression) {
        return expression.equalsIgnoreCase(startExpressionWord);
    }

}
