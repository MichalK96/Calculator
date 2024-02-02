package com.storeware.calculator.application.core;

import com.storeware.calculator.configuration.CalculatorConfigurations;
import com.storeware.calculator.application.core.exception.InvalidQuantityApplyOperatorException;
import com.storeware.calculator.infrastructure.Expression;

import java.util.List;
import java.util.Objects;

public class Engine {

    private final CalculationHandler calculationHandler = new CalculationHandler();

    private final CalculatorConfigurations config;
    private List<Expression> inputData;

    public Engine(CalculatorConfigurations config) {
        this.config = config;
    }

    public void run() {
        inputData = config.getInputHandler().readInput();
        validateInputData();

        var result = calculationHandler.count(inputData);
        config.getOutputHandler().handleResult(result, config.getInputHandler().getFilePath());
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
