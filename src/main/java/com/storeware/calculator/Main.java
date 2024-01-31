package com.storeware.calculator;

import com.storeware.calculator.application.core.Engine;
import com.storeware.calculator.infrastructure.input.FileInputHandler;
import com.storeware.calculator.infrastructure.output.ConsoleMessageOutputHandler;

public class Main {
    public static void main(String[] args) {

        var calculatorConfiguration = CalculatorResources.factory()
                .inputStrategy(new FileInputHandler())
                .outputStrategy(new ConsoleMessageOutputHandler())
                .build();
        var engine = new Engine(calculatorConfiguration);

        engine.run();

    }
}