package com.storeware.calculator.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorUtilsTest {

    @Test
    void getNumber_CorrectValue_10() {
        String expression = "add 10";
        int result = CalculatorUtils.getNumber(expression);
        assertEquals(10, result);
    }

    @Test
    void getNumber_CorrectValue_123456789() {
        String expression = "abcde123fghij123456789";
        int result = CalculatorUtils.getNumber(expression);
        assertEquals(123456789, result);
    }

    @Test
    void getNumber_IncorrectValue() {
        String expression = " ";
        try {
            int result = CalculatorUtils.getNumber(expression);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No number provided", e.getMessage());
        }
    }

    @Test
    void getOperator_CorrectValue_add() {
        String expression = "add 5";
        String result = CalculatorUtils.getOperator(expression);
        assertEquals("add", result);
    }

    @Test
    void getOperator_CorrectValue_multiplication() {
        String expression = "multiplication 5";
        String result = CalculatorUtils.getOperator(expression);
        assertEquals("multiplication", result);
    }

    @Test
    void getOperator_IncorrectValue_NoOperator() {
        String expression = "5";
        try {
            String result = CalculatorUtils.getOperator(expression);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No operator provided", e.getMessage());
        }
    }



}