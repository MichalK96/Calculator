package com.michal.calculator.infrastructure.input;

import com.michal.calculator.application.core.exception.InvalidValueException;
import com.michal.calculator.infrastructure.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

class LineExpressionConverterTest {

//    private static Stream<Object[]> testData() {
//        return Stream.of(
//                new Object[]{"add 10", "10", Operator.ADD},
//                new Object[]{"subtract 5", "5", Operator.SUBTRACT},
//                new Object[]{"add 12,12", "12.12", Operator.ADD},
//                new Object[]{"add 12.12", "12.12", Operator.ADD},
//                new Object[]{"add 123456789.123456789", "123456789.123456789", Operator.ADD},
//                new Object[]{"add 123456789123456789", "123456789123456789", Operator.ADD},
//                new Object[]{"subtract 123", "123", Operator.SUBTRACT},
//                new Object[]{"divide 123", "123", Operator.DIVIDE},
//                new Object[]{"multiply 123", "123", Operator.MULTIPLY}
//        );
//    }
//    @ParameterizedTest
//    @MethodSource("testData")
//    @DisplayName("When provided operator with natural or floating-point number and point or comma separator then return converted expression")
//    void when_providedOperatorWithNaturalNumber_then_returnConvertedExpressionn(
//            String expression, String expectedNumber, Operator expectedOperator) {
//        //When
//        var result = LineExpressionConverter.createExpression(expression);
//        //Then
//        assertThat(result.getNumber()).isEqualTo(expectedNumber);
//        assertThat(result.getOperator()).isEqualTo(expectedOperator);
//    }

    @Test
    @DisplayName("When provided operator with natural number then return converted expression")
    void when_providedOperatorWithNaturalNumber_then_returnConvertedExpression() {
        //Given
        var expectedNumber = "10";
        var expectedOperator = Operator.ADD;
        var expression = "add 10";
        //When
        var result = LineExpressionConverter.createExpression(expression);
        //Then
        assertThat(result.getNumber()).isEqualTo(expectedNumber);
        assertThat(result.getOperator()).isEqualTo(expectedOperator);
    }

    @Test
    @DisplayName("When provided operator with floating-point number then return converted expression")
    void when_providedOperatorWithFloatingPointNumber_then_returnConvertedExpression() {
        //Given
        var expectedNumber = "274.7";
        var expectedOperator = Operator.DIVIDE;
        var expression = "divide 274.7";
        //When
        var result = LineExpressionConverter.createExpression(expression);
        //Then
        assertThat(result.getNumber()).isEqualTo(expectedNumber);
        assertThat(result.getOperator()).isEqualTo(expectedOperator);
    }

    @Test
    @DisplayName("When provided operator is uppercase then return converted expression")
    void when_providedOperatorIsUppercase_then_returnConvertedExpression() {
        //Given
        var expectedNumber = "1234";
        var expectedOperator = Operator.SUBTRACT;
        var expression = "SUBTRACT 1234";
        //When
        var result = LineExpressionConverter.createExpression(expression);
        //Then
        assertThat(result.getNumber()).isEqualTo(expectedNumber);
        assertThat(result.getOperator()).isEqualTo(expectedOperator);
    }

    @Test
    @DisplayName("When provided operator is mixed case then return converted expression")
    void when_providedOperatorIsMixedCase_then_returnConvertedExpression() {
        //Given
        var expectedNumber = "1234";
        var expectedOperator = Operator.SUBTRACT;
        var expression = "SuBtrACt 1234";
        //When
        var result = LineExpressionConverter.createExpression(expression);
        //Then
        assertThat(result.getNumber()).isEqualTo(expectedNumber);
        assertThat(result.getOperator()).isEqualTo(expectedOperator);
    }

    @Test
    @DisplayName("When no number then return operator")
    void when_noNumber_then_throwException() {
        //Given
        BigDecimal expectdNumber = null;
        var expectdOperator = Operator.DONE;
        var expression = "DONE";
        //When
        var result = LineExpressionConverter.createExpression(expression);
        //Then
        assertThat(result.getNumber()).isEqualTo(expectdNumber);
        assertThat(result.getOperator()).isEqualTo(expectdOperator);
    }

    @Test
    @DisplayName("When invalid number then throw exception")
    void when_invalidNumber_then_throwException() {
        //Given
        var expected = InvalidValueException.class;
        var expression = "add 10.,7";
        //When
        var exception = catchException(() -> LineExpressionConverter.createExpression(expression));
        //Then
        assertThat(exception).isInstanceOf(expected);
        assertThat(exception.getMessage()).containsIgnoringCase("invalid number");
    }

    @Test
    @DisplayName("When no operator then throw exception")
    void when_noOperator_then_throwException() {
        //Given
        var expected = IllegalArgumentException.class;
        var expression = "10";
        //When
        var exception = catchException(() -> LineExpressionConverter.createExpression(expression));
        //Then
        assertThat(exception).isInstanceOf(expected);
        assertThat(exception.getMessage()).containsIgnoringCase("no operator");
    }

    @Test
    @DisplayName("When invalid operator then throw exception")
    void when_invalidOperator_then_throwException() {
        //Given
        var expected = InvalidValueException.class;
        var expression = "ad 10";
        //When
        var exception = catchException(() -> LineExpressionConverter.createExpression(expression));
        //Then
        assertThat(exception).isInstanceOf(expected);
        assertThat(exception.getMessage()).containsIgnoringCase("invalid operator");
    }

}