package com.michal.calculator.application.core;

import com.michal.calculator.application.core.exception.DivideByZeroException;
import com.michal.calculator.infrastructure.Expression;
import com.michal.calculator.infrastructure.Operator;
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
                buildExpression("10", Operator.ADD),
                buildExpression("5", Operator.APPLY)
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
                buildExpression("10", Operator.ADD),
                buildExpression("1", Operator.ADD),
                buildExpression("5", Operator.ADD),
                buildExpression("4", Operator.ADD),
                buildExpression("6", Operator.APPLY)
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
                buildExpression("10.75", Operator.ADD),
                buildExpression("1.2", Operator.ADD),
                buildExpression("5.400", Operator.ADD),
                buildExpression("4.25", Operator.ADD),
                buildExpression("6.5", Operator.APPLY)
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
                buildExpression("5", Operator.SUBTRACT),
                buildExpression("15", Operator.APPLY)
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
                buildExpression("5",  Operator.SUBTRACT),
                buildExpression("10",  Operator.SUBTRACT),
                buildExpression("7",  Operator.SUBTRACT),
                buildExpression("3",  Operator.SUBTRACT),
                buildExpression("400", Operator.APPLY)
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
                buildExpression("5.5", Operator.SUBTRACT),
                buildExpression("11.2", Operator.SUBTRACT),
                buildExpression("7.7", Operator.SUBTRACT),
                buildExpression("3.2", Operator.SUBTRACT),
                buildExpression("250.3", Operator.APPLY)
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
                buildExpression("5", Operator.MULTIPLY),
                buildExpression("5", Operator.APPLY)
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
                buildExpression("10", Operator.MULTIPLY),
                buildExpression("2", Operator.MULTIPLY),
                buildExpression("4", Operator.MULTIPLY),
                buildExpression("1", Operator.MULTIPLY),
                buildExpression("5", Operator.APPLY)
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
                buildExpression("10.2", Operator.MULTIPLY),
                buildExpression("2.1", Operator.MULTIPLY),
                buildExpression("4.7", Operator.MULTIPLY),
                buildExpression("1.3", Operator.MULTIPLY),
                buildExpression("5.5", Operator.APPLY)
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
                buildExpression("4", Operator.DIVIDE),
                buildExpression("20", Operator.APPLY)
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
                buildExpression("2", Operator.DIVIDE),
                buildExpression("5", Operator.DIVIDE),
                buildExpression("10", Operator.DIVIDE),
                buildExpression("1", Operator.DIVIDE),
                buildExpression("200", Operator.APPLY)
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
                buildExpression("2.5", Operator.DIVIDE),
                buildExpression("5.7", Operator.DIVIDE),
                buildExpression("10.1", Operator.DIVIDE),
                buildExpression("1.2", Operator.DIVIDE),
                buildExpression("200.6", Operator.APPLY)
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
                buildExpression("0", Operator.DIVIDE),
                buildExpression("20", Operator.APPLY)
        );
        //When
        var exception = catchException(() -> calculationHandler.count(expressions));
        //Then
        assertThat(exception).isInstanceOf(DivideByZeroException.class);
        assertThat(exception.getMessage()).containsIgnoringCase("zero");
    }

    @Test
    @DisplayName("When many operations with natural numbers then return result")
    void when_manyOperationWithNaturalNumbers_then_returnResult() {
        //Given
        var expected = "101";
        var expressions = List.of(
                buildExpression("150", Operator.SUBTRACT),
                buildExpression("2", Operator.DIVIDE),
                buildExpression("4", Operator.MULTIPLY),
                buildExpression("1", Operator.ADD),
                buildExpression("200", Operator.APPLY)
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
                buildExpression("4", Operator.MULTIPLY),
                buildExpression("2.2", Operator.DIVIDE),
                buildExpression("4.75", Operator.SUBTRACT),
                buildExpression("0.25", Operator.ADD),
                buildExpression("5.5", Operator.APPLY)
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
                buildExpression("10", Operator.MULTIPLY),
                buildExpression("5", Operator.DIVIDE),
                buildExpression("5453664", Operator.ADD),
                buildExpression("4585677", Operator.SUBTRACT),
                buildExpression("785445", Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When only apply expression then return result")
    void when_onlyApplyExpression_then_returnResult() {
        //Given
        var expected = "2438877";
        var expressions = List.of(
                buildExpression(expected, Operator.APPLY)
        );
        //When
        var result = calculationHandler.count(expressions);
        //Then
        assertThat(result).isEqualByComparingTo(expected);
    }

    @Test
    @DisplayName("When no operator then return exception")
    void when_noOperator_then_throwException() {
        //Given
        var expected = NullPointerException.class;
        var expressions = List.of(
                buildExpression("10", null)
        );
        //When
        var exception = catchException(() -> calculationHandler.count(expressions));
        //Then
        assertThat(exception).isInstanceOf(expected);
    }

    private Expression buildExpression(String number, Operator operator) {
        return Expression.builder()
                .number(new BigDecimal(number))
                .operator(operator)
                .build();
    }

}