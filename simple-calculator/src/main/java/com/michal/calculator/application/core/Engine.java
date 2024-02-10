package com.michal.calculator.application.core;

import com.michal.calculator.configuration.CalculatorConfiguration;
import com.michal.calculator.application.core.exception.InvalidQuantityApplyOperatorException;
import com.michal.calculator.infrastructure.Expression;

import java.util.List;
import java.util.Objects;

public class Engine {

    private final CalculationHandler calculationHandler = new CalculationHandler();

    private final CalculatorConfiguration config;
    private List<Expression> inputData;

    public Engine(CalculatorConfiguration config) {
        this.config = config;
    }

    public void run() {
        inputData = config.getInputHandler().readInput();
        validateInputData();

        var result = calculationHandler.count(inputData).toPlainString();
        config.getOutputHandler().handleResult(result);
    }

    private void validateInputData() {
        Objects.requireNonNull(inputData, "No data provided");
        if (inputData.isEmpty()) {
            throw new IllegalArgumentException("Empty expressions list");
        }
        var numStartExpression = inputData.stream()
                .filter(Expression::isStartExpression)
                .count();
        if (numStartExpression != 1) {
            throw new InvalidQuantityApplyOperatorException("Number of apply form is different than one");
        }
    }

}
