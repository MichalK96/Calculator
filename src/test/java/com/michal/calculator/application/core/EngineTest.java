package com.michal.calculator.application.core;

import com.michal.calculator.configuration.CalculatorConfigurations;
import com.michal.calculator.application.core.exception.InvalidQuantityApplyOperatorException;
import com.michal.calculator.infrastructure.Expression;
import com.michal.calculator.infrastructure.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class EngineTest {

    private FakeOutputHandler outputHandler;
    private Engine engine;

    @BeforeEach
    void setUp() {
        outputHandler = new FakeOutputHandler();
    }

    @Test
    @DisplayName("When expressions list with APPLY operator then return result")
    void when_expressionsListWithApplyOperator_then_returnResult() {
        //Given
        var expected = "40";
        var expressions = List.of(
                buildExpression("10", Operator.ADD),
                buildExpression("2", Operator.MULTIPLY),
                buildExpression("10", Operator.APPLY)
        );
        prepareEngine(expressions);
        //When
        engine.run();
        //Then
        assertThat(outputHandler.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("When expressions list with only APPLY operator then return result")
    void when_expressionsListWithOnlyApplyOperator_then_returnResult() {
        //Given
        var expected = "10";
        var expressions = List.of(
                buildExpression(expected, Operator.APPLY)
        );
        prepareEngine(expressions);
        //When
        engine.run();
        //Then
        assertThat(outputHandler.getResult()).isEqualTo(expected);
    }

    @Test
    @DisplayName("When expressions list without APPLY operator then throw exception")
    void when_expressionsListWithoutApplyOperator_then_throwException() {
        //Given
        var expected = InvalidQuantityApplyOperatorException.class;
        var expressions = List.of(
                buildExpression("10", Operator.ADD),
                buildExpression("2", Operator.MULTIPLY),
                buildExpression("5", Operator.SUBTRACT)
        );
        prepareEngine(expressions);
        //When
        var exception = catchException(() -> engine.run());
        //Then
        assertThat(exception).isInstanceOf(expected);
    }

    @Test
    @DisplayName("When no expressions list then return exception")
    void when_noExpressionsList_then_returnException() {
        //Given
        var expected = NullPointerException.class;
        List<Expression> expressions = null;
        prepareEngine(expressions);
        //When
        var exception = catchException(() -> engine.run());
        //Then
        assertThat(exception).isInstanceOf(expected);
        assertThat(exception.getMessage()).containsIgnoringCase("no data");
    }

    @Test
    @DisplayName("When empty expressions list then return exception")
    void when_emptyExpressionsList_then_returnException() {
        //Given
        var expected = IllegalArgumentException.class;
        List<Expression> expressions = List.of();
        prepareEngine(expressions);
        //When
        var exception = catchException(() -> engine.run());
        //Then
        assertThat(exception).isInstanceOf(expected);
        assertThat(exception.getMessage()).containsIgnoringCase("empty");
    }


    private void prepareEngine(List<Expression> expressions) {
        var inputHandler = new FakeInputHandler(expressions);
        var resources = new CalculatorConfigurations(inputHandler, outputHandler);
        engine = new  Engine(resources);
    }

    private Expression buildExpression(String number, Operator operator) {
        return Expression.builder()
                .number(new BigDecimal(number))
                .operator(operator)
                .build();
    }
}