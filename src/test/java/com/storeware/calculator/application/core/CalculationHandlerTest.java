package com.storeware.calculator.application.core;

import com.storeware.calculator.application.core.exception.DevideByZeroException;
import com.storeware.calculator.infrastructure.Expression;
import com.storeware.calculator.infrastructure.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CalculationHandlerTest {

    private CalculationHandler calculationHandler;

    @BeforeEach
    void setUp() {
        calculationHandler = new CalculationHandler();
    }

    @Test
    @DisplayName("When single add operation with natural numbers then return result")
    void when_singleAddOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "15";
        var expressions = List.of(
                generateExpression("10", Operator.ADD),
                generateExpression("5", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many add operations with natural numbers then return result")
    void when_manyAddOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "26";

        var expressions = List.of(
                generateExpression("10", Operator.ADD),
                generateExpression("1", Operator.ADD),
                generateExpression("5", Operator.ADD),
                generateExpression("4", Operator.ADD),
                generateExpression("6", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many add operations with floating-point numbers then return result")
    void when_manyAddOperationWithFloatingPointNumbers_then_returnResult() {
        //Given
        var expected = "28.1";
        var expressions = List.of(
                generateExpression("10.75", Operator.ADD),
                generateExpression("1.2", Operator.ADD),
                generateExpression("5.400", Operator.ADD),
                generateExpression("4.25", Operator.ADD),
                generateExpression("6.5", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When single subtraction operation with natural numbers then return result")
    void when_singleSubtractionOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "10";
        var expressions = List.of(
                generateExpression("5", Operator.SUBTRACT),
                generateExpression("15", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many subtraction operations with natural numbers then return result")
    void when_manySubtractionOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "375";
        var expressions = List.of(
                generateExpression("5",  Operator.SUBTRACT),
                generateExpression("10",  Operator.SUBTRACT),
                generateExpression("7",  Operator.SUBTRACT),
                generateExpression("3",  Operator.SUBTRACT),
                generateExpression("400", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many subtraction operations with floating-points numbers then return result")
    void when_manySubtractionOperationWithFloatingPointNumbers_then_returnResult() {
        //Given
        var expected = "222.7";
        var expressions = List.of(
                generateExpression("5.5", Operator.SUBTRACT),
                generateExpression("11.2", Operator.SUBTRACT),
                generateExpression("7.7", Operator.SUBTRACT),
                generateExpression("3.2", Operator.SUBTRACT),
                generateExpression("250.3", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
//        assertThat(result).isCloseTo(expected, within(0.00000000001));
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When single multiplication operation with natural numbers then return result")
    void when_singleMultiplicationOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "25";
        var expressions = List.of(
                generateExpression("5", Operator.MULTIPLY),
                generateExpression("5", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many multiplication operations with natural numbers then return result")
    void when_manyMultiplicationOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "400";
        var expressions = List.of(
                generateExpression("10", Operator.MULTIPLY),
                generateExpression("2", Operator.MULTIPLY),
                generateExpression("4", Operator.MULTIPLY),
                generateExpression("1", Operator.MULTIPLY),
                generateExpression("5", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many multiplication operations with floating-point numbers then return result")
    void when_manyMultiplicationOperationWithFloatingPointNumbers_then_returnResult() {
        //Given
        var expected = "719.8191";
        var expressions = List.of(
                generateExpression("10.2", Operator.MULTIPLY),
                generateExpression("2.1", Operator.MULTIPLY),
                generateExpression("4.7", Operator.MULTIPLY),
                generateExpression("1.3", Operator.MULTIPLY),
                generateExpression("5.5", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When single division operation with natural numbers then return result")
    void when_singleDivisionOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "5";
        var expressions = List.of(
                generateExpression("4", Operator.DIVIDE),
                generateExpression("20", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many division operations with natural numbers then return result")
    void when_manyDivisionOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "2";
        var expressions = List.of(
                generateExpression("2", Operator.DIVIDE),
                generateExpression("5", Operator.DIVIDE),
                generateExpression("10", Operator.DIVIDE),
                generateExpression("1", Operator.DIVIDE),
                generateExpression("200", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many division operations with floating-point numbers then return result")
    void when_manyDivisionOperationWithFloatingPointNumbers_then_returnResult() {
        //Given
        var expected = "1.16148456950";
        var expressions = List.of(
                generateExpression("2.5", Operator.DIVIDE),
                generateExpression("5.7", Operator.DIVIDE),
                generateExpression("10.1", Operator.DIVIDE),
                generateExpression("1.2", Operator.DIVIDE),
                generateExpression("200.6", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When divide by 0 than throw exception")
    void when_divideBy0_then_throwException() {
        //Given
        var expressions = List.of(
                generateExpression("0", Operator.DIVIDE),
                generateExpression("20", Operator.APPLY)
        );
        //When
        var exception = catchException(() -> calculationHandler.count(expressions));
        //Then
        assertThat(exception).isInstanceOf(DevideByZeroException.class);
        assertThat(exception.getMessage()).containsIgnoringCase("zero");
    }

    @Test
    @DisplayName("When many operations with natural numbers then return result")
    void when_manyOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "101";
        var expressions = List.of(
                generateExpression("150", Operator.SUBTRACT),
                generateExpression("2", Operator.DIVIDE),
                generateExpression("4", Operator.MULTIPLY),
                generateExpression("1", Operator.ADD),
                generateExpression("200", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many operations with floating-point numbers then return result")
    void when_manyOperationWithFloatingPointNumbers_then_returnResult() {
        //Given
        var expected = "5.5";
        var expressions = List.of(
                generateExpression("4", Operator.MULTIPLY),
                generateExpression("2.2", Operator.DIVIDE),
                generateExpression("4.75", Operator.SUBTRACT),
                generateExpression("0.25", Operator.ADD),
                generateExpression("5.5", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When many operations with large natural numbers then return result")
    void when_manyOperationWithLargeFloatingPointNumbers_then_returnResult() {
        //Given
        var expected = "2438877";
        var expressions = List.of(
                generateExpression("10", Operator.MULTIPLY),
                generateExpression("5", Operator.DIVIDE),
                generateExpression("5453664", Operator.ADD),
                generateExpression("4585677", Operator.SUBTRACT),
                generateExpression("785445", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    private Expression generateExpression(String number, Operator operator) {
        return Expression.builder()
                .number(new BigDecimal(number))
                .operator(operator)
                .build();
    }

}