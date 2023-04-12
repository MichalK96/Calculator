package com.storeware.calculator.calculator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculateSetOfOperations_Add_CorrectValue() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        operations.add("add 5");
        operations.add("apply 5");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(10, result);
    }

    @Test
    void calculateSetOfOperations_Subtract_CorrectValue() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        operations.add("subtract 5");
        operations.add("apply 10");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(5, result);
    }

    @Test
    void calculateSetOfOperations_Multiplication_CorrectValue() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        operations.add("multiply 2");
        operations.add("apply 2");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(4, result);
    }

    @Test
    void calculateSetOfOperations_Divide_CorrectValue() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        operations.add("divide 5");
        operations.add("apply 15");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(3, result);
    }

    @Test
    void calculateSetOfOperations_Divide_ByZero() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        operations.add("divide 0");
        operations.add("apply 4");
        try {
            int result = calculator.calculateSetOfOperations(operations);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot divide by zero", e.getMessage());

        }
    }

    @Test
    void calculateSetOfOperations_InvalidOperator() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        operations.add("abc 5");
        operations.add("apply 5");
        try {
            int result = calculator.calculateSetOfOperations(operations);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid operator", e.getMessage());
        }
    }

    @Test
    void calculateSetOfOperations_ManyOperations_CorrectValue() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        operations.add("add 10");
        operations.add("subtract 10");
        operations.add("multiply 2");
        operations.add("divide 2");
        operations.add("subtract 5");
        operations.add("add 10");
        operations.add("apply 10");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(15, result);
    }

    @Test
    void calculateSetOfOperations_EmptyList() {
        Calculator calculator = new Calculator();
        List<String> operations = new ArrayList<>();
        try {
            int result = calculator.calculateSetOfOperations(operations);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No Operations provided", e.getMessage());
        }
    }

    @Test
    void calculateOperation_Add_CorrectValue() {
        Calculator calculator = new Calculator();
        int result = calculator.calculateOperation(10, "add 5");
        assertEquals(15, result);
    }

    @Test
    void calculateOperation_Subtract_CorrectValue() {
        Calculator calculator = new Calculator();
        int result = calculator.calculateOperation(10, "subtract 5");
        assertEquals(5, result);
    }

    @Test
    void calculateOperation_Multiply_CorrectValue() {
        Calculator calculator = new Calculator();
        int result = calculator.calculateOperation(10, "multiply 4");
        assertEquals(40, result);
    }

    @Test
    void calculateOperation_Divide_CorrectValue() {
        Calculator calculator = new Calculator();
        int result = calculator.calculateOperation(200, "divide 4");
        assertEquals(50, result);
    }

    @Test
    void calculateOperation_DivideByZero() {
        Calculator calculator = new Calculator();
        try {
            int result = calculator.calculateOperation(10, "divide 0");
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot divide by zero", e.getMessage());
        }
    }

    @Test
    void calculateOperation_InvalidOperator() {
        Calculator calculator = new Calculator();
        try {
            int result = calculator.calculateOperation(10, "abc 2");
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid operator", e.getMessage());
        }
    }

}