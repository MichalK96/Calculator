package com.storeware.calculator;

import com.storeware.calculator.core.Engine;
import com.storeware.calculator.infrastructure.input.FileInputHandler;
import com.storeware.calculator.infrastructure.output.ConsoleMessageOutputHandler;

public class Main {
    public static void main(String[] args) {

        var calculatorResources = CalculatorResources.factory()
                .inputStrategy(new FileInputHandler())
                .outputStrategy(new ConsoleMessageOutputHandler())
                .build();

        var engine = new Engine(calculatorResources);


//        final var calculator = new Calculator();
//        final var fileReader = new FileInputReader();
//
//        var operations = fileReader.readFile();
//        var result = calculator.calculateSetOfOperations(operations);
//        ConsoleDisplay.displayResult(result);

    }
}