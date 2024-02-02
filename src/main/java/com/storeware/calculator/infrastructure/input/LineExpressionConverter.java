package com.storeware.calculator.infrastructure.input;

import com.storeware.calculator.application.core.exception.InvalidValueException;
import com.storeware.calculator.infrastructure.Expression;
import com.storeware.calculator.infrastructure.Operator;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

class LineExpressionConverter {

    private static final String startExpressionWord = "apply";
    private static final HashSet<Character> allowedChars = new HashSet<>(Set.of('.', ','));

    private LineExpressionConverter() {
        throw new IllegalStateException("Utility class");
    }

    static Expression createExpression(String lineExpression) {
        return Expression.builder()
                .number(getNumber(lineExpression))
                .operator(getOperator(lineExpression))
                .build();
    }

    private static BigDecimal getNumber(String expression) {
        StringBuilder output = new StringBuilder();
        for (int i = expression.length() - 1;i >= 0; i--) {
            if (isPartOfNumber(expression.charAt(i))) {

                output.append(expression.charAt(i));
            } else {
                if (output.isEmpty()) {
                    throw new IllegalArgumentException("No number provided");
                }
                break;
            }
        }
        output.replace(0, output.length(), output.toString().replace(',', '.'));
        validateValue(output);
        output.reverse();
        return new BigDecimal(String.valueOf(output));
    }

    private static Operator getOperator(String expression) {
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
            return Operator.valueOf(operator.toString().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidValueException("Invalid operator: " + operator);
        }
    }

    private static void validateValue(StringBuilder value) {
        var chars = 0;
        for (var i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '.') {
                chars++;
                if (chars > 1) {
                    throw new InvalidValueException("Invalid number provided");
                }
            }
        }
    }

    private static boolean isStartExpression(String expression) {
        return expression.equalsIgnoreCase(startExpressionWord);
    }

    private static boolean isPartOfNumber(char character) {
        return Character.isDigit(character) || allowedChars.contains(character);
    }

}
