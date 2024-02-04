package com.michal.calculator.configuration;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.application.port.out.OutputStrategy;
import com.michal.calculator.infrastructure.input.ConsoleInputHandler;
import com.michal.calculator.infrastructure.input.FileInputHandler;
import com.michal.calculator.infrastructure.output.ConsoleFileOutputHandler;
import com.michal.calculator.infrastructure.output.ConsoleOutputHandler;
import com.michal.calculator.infrastructure.output.FileOutputHandler;
import com.michal.calculator.util.ConsolePrinter;
import com.michal.calculator.util.ConsoleReader;

public class ConfigurationHandler {

    private ConfigurationHandler() {}

    public static InputStrategy setInputStrategy() {
        ConsolePrinter.printInfo("Select data source\n1 File\n2 Enter manually ");
        var userInput = ConsoleReader.consoleReadString();
        return switch (userInput) {
            case "1" -> new FileInputHandler();
            case "2" -> new ConsoleInputHandler();
            default -> {
                ConsolePrinter.printWarn("Provide correct value");
                yield setInputStrategy();
            }
        };
    }

    public static OutputStrategy setOutputStrategy() {
        ConsolePrinter.printInfo("""
                Where result should be placed
                1 File
                2 Console
                3 File and console
                """);
        var userInput = ConsoleReader.consoleReadString();
        return switch (userInput) {
            case "1" -> new FileOutputHandler();
            case "2" -> new ConsoleOutputHandler();
            case "3" -> new ConsoleFileOutputHandler();
            default -> {
                ConsolePrinter.printWarn("Provide correct value");
                yield setOutputStrategy();
            }
        };
    }

}
