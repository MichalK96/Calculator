package com.storeware.calculator.calculator;

public class CalculatorUtils {

    static int getNumber(String expression) {
        StringBuilder output = new StringBuilder();
        for (int i = expression.length() - 1;i >= 0; i--) {
            if (isDigit(expression.charAt(i))) {
                output.append(expression.charAt(i));
            } else {
                break;
            }
        }
        output.reverse();
        return Integer.parseInt(String.valueOf(output));
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    static String getOperator(String expression) {
        StringBuilder operator = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (isLetter(expression.charAt(i))) {
                operator.append(expression.charAt(i));
            } else {
                break;
            }
        }
        return operator.toString();
    }

}