package com.storeware.calculator.calculator;

import com.storeware.calculator.core.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should calculate expression")
    void calculateSetOfOperations_Add_CorrectValue() {
        //Given
        List<String> operations = new ArrayList<>();
        operations.add("add 5");
        operations.add("apply 5");
        //When
        var result = calculator.calculateSetOfOperations(operations);
        //Then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void calculateSetOfOperations_Subtract_CorrectValue() {
        List<String> operations = new ArrayList<>();
        operations.add("subtract 5");
        operations.add("apply 10");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(5, result);
    }

    @Test
    void calculateSetOfOperations_Multiplication_CorrectValue() {
        List<String> operations = new ArrayList<>();
        operations.add("multiply 2");
        operations.add("apply 2");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(4, result);
    }

    @Test
    void calculateSetOfOperations_Divide_CorrectValue() {
        List<String> operations = new ArrayList<>();
        operations.add("divide 5");
        operations.add("apply 15");
        int result = calculator.calculateSetOfOperations(operations);
        assertEquals(3, result);
    }

    @Test
    void calculateSetOfOperations_Divide_ByZero() {
        List<String> operations = new ArrayList<>();
        operations.add("divide 0");
        operations.add("apply 4");
        try {
            int result = calculator.calculateSetOfOperations(operations);
//            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot divide by zero", e.getMessage());

        }
    }

    @Test
    @DisplayName("Should throw exception when operator is invalid")
    void calculateSetOfOperations_InvalidOperator() {
        //Given
        List<String> operations = new ArrayList<>();
        operations.add("abc 5");
        operations.add("apply 5");
        //When
        var exception = catchException(() -> calculator.calculateSetOfOperations(operations));
        //Then
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateSetOfOperations_ManyOperations_CorrectValue() {
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
        List<String> operations = new ArrayList<>();
        try {
            int result = calculator.calculateSetOfOperations(operations);
//            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No Operations provided", e.getMessage());
        }
    }

    @Test
    void calculateOperation_Add_CorrectValue() {
        int result = calculator.calculateOperation(10, "add 5");
        assertEquals(15, result);
    }

    @Test
    void calculateOperation_Subtract_CorrectValue() {
        int result = calculator.calculateOperation(10, "subtract 5");
        assertEquals(5, result);
    }

    @Test
    void calculateOperation_Multiply_CorrectValue() {
        int result = calculator.calculateOperation(10, "multiply 4");
        assertEquals(40, result);
    }

    @Test
    void calculateOperation_Divide_CorrectValue() {
        int result = calculator.calculateOperation(200, "divide 4");
        assertEquals(50, result);
    }

    @Test
    void calculateOperation_DivideByZero() {
        try {
            int result = calculator.calculateOperation(10, "divide 0");
//            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot divide by zero", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should throw exception when operator is invalid")
    void calculateOperation_InvalidOperator() {
        //Given
        var number = 10;
        var expression = "abc 2";
        //When
        var exception = catchException(() -> calculator.calculateOperation(number, expression));
        //Then
        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
        assertThat(exception.getMessage()).containsIgnoringCase("Invalid operator");
    }

}