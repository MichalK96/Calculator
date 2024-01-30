package com.storeware.calculator.calculator;

import com.storeware.calculator.core.ArithmeticOperator;
import com.storeware.calculator.core.CalculatorUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class CalculatorResourcesUtilsTest {

//    @Test
//    @DisplayName("Should extract number from expression")
//    void getNumber_CorrectValue_10() {
//        //Given
//        String expression = "add 10";
//        //When
//        var result = CalculatorUtils.getNumber(expression);
//        //Then
//        assertThat(result).isEqualTo(10);
//    }
//
//    @Test
//    void getNumber_CorrectValue_123456789() {
//        String expression = "abcde123fghij123456789";
//        int result = CalculatorUtils.getNumber(expression);
//        assertEquals(123456789, result);
//    }
//
//    @Test
//    @DisplayName("Should throw exception when expression is incorrect")
//    void getNumber_IncorrectValue() {
//        //Given
//        String expression = " ";
//        //When
//        var exception = catchException(() -> CalculatorUtils.getNumber(expression));
//        //Then
//        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
//        assertThat(exception.getMessage()).containsIgnoringCase("no number");
//    }
//
//    @Test
//    void getOperator_CorrectValue_add() {
//        String expression = "add 5";
//        var result = CalculatorUtils.getOperator(expression);
//        assertEquals(ArithmeticOperator.ADD, result);
//    }
//
//    @Test
//    void getOperator_CorrectValue_multiplication() {
//        String expression = "multiply 5";
//        var result = CalculatorUtils.getOperator(expression);
//        assertEquals(ArithmeticOperator.MULTIPLY, result);
//    }
//
//    @Test
//    @DisplayName("Should throw exception when no operator provided")
//    void getOperator_IncorrectValue_NoOperator() {
//        //Given
//        String expression = "5";
//        //When
//        var exception = catchException(() -> CalculatorUtils.getOperator(expression));
//        //Then
//        assertThat(exception).isInstanceOf(IllegalArgumentException.class);
//        assertThat(exception.getMessage()).containsIgnoringCase("no operator");
//    }



}