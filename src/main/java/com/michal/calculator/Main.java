package com.michal.calculator;

import com.michal.calculator.application.core.Engine;
import com.michal.calculator.configuration.CalculatorConfigurations;
import com.michal.calculator.configuration.ConfigurationHandler;
import com.michal.calculator.util.ConsolePrinter;
import com.michal.calculator.util.ConsoleReader;

public class Main {
    public static void main(String[] args) {

        displayManual();

        var calculatorConfiguration = CalculatorConfigurations.factory()
                .inputStrategy(ConfigurationHandler.setInputStrategy())
                .outputStrategy(ConfigurationHandler.setOutputStrategy())
                .build();
        var engine = new Engine(calculatorConfiguration);

        engine.run();
    }

    private static void displayManual() {
        ConsolePrinter.printInfo("Do you want to read the manual (y/n)");
        if (ConsoleReader.userConfirm()) {
            ConsolePrinter.printInfo("""
                    \n\nYou can provide data for calculator manually, use default input.txt file or provide path to your own txt file
                    For result you can select display in console, write to provided previously file (not supported for manually data providing) or both
                    
                    The calculator does not support the order of operations
                    
                    Providing data instruction
                    Calculator has five operators:
                    APPLY, ADD, SUBTRACT, MULTIPLY, DIVIDE, DONE
                    
                    use APPLY with first number to start sequence (apply 10.5)
                    add another operators with numbers to your calculations (divide 2)
                    when to finish provide done (not required for txt files)
                    """);
        }
    }
}