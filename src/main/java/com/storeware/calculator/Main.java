package com.storeware.calculator;

import com.storeware.calculator.application.core.Engine;
import com.storeware.calculator.configuration.CalculatorConfigurations;
import com.storeware.calculator.configuration.ConfigurationHandler;
import com.storeware.calculator.infrastructure.output.ConsoleOutputHandler;

public class Main {
    public static void main(String[] args) {

        var calculatorConfiguration = CalculatorConfigurations.factory()
                .inputStrategy(ConfigurationHandler.setInputStrategy())
                .outputStrategy(ConfigurationHandler.setOutputStrategy())
                .build();
        var engine = new Engine(calculatorConfiguration);

        engine.run();

    }
}