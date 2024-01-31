package com.storeware.calculator.application.core;

import com.storeware.calculator.CalculatorResources;
import com.storeware.calculator.infrastructure.Expression;

import java.util.List;
import java.util.Objects;

public class Engine {

    private final CalculationHandler calculationHandler = new CalculationHandler();

    private final CalculatorResources resources;
    private List<Expression> inputData;

    public Engine(CalculatorResources resources) {
        this.resources = resources;
    }

    public void run() {
        inputData = resources.getInputHandler().readInput();
        validateInputData();

        var result = calculationHandler.count(inputData);
        resources.getOutputHandler().handleResult(result);
    }

    private void validateInputData() {
        Objects.requireNonNull(inputData, "No data provided");
        var numStartExpression = inputData.stream()
                .filter(Expression::isStartExpression)
                .count();
        if (numStartExpression != 1) {
            throw new IllegalArgumentException("Number of apply form is different than one");
        }
    }

}
