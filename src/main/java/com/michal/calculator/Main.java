package com.michal.calculator;

import com.michal.calculator.application.core.Engine;
import com.michal.calculator.configuration.CalculatorConfiguration;
import com.michal.calculator.configuration.ConfigurationHandler;

import static com.michal.calculator.util.ConsoleUtil.displayManual;

public class Main {
    public static void main(String[] args) {

        displayManual();

        var calculatorConfiguration = CalculatorConfiguration.factory()
                .properties(ConfigurationHandler.setProperties())
                .generateInputStrategy()
                .generateOutputStrategy()
                .build();
        var engine = new Engine(calculatorConfiguration);

        engine.run();
    }

}