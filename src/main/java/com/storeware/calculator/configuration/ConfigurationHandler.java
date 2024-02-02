package com.storeware.calculator.configuration;

import com.storeware.calculator.application.port.in.InputStrategy;
import com.storeware.calculator.application.port.out.OutputStrategy;
import com.storeware.calculator.infrastructure.input.ConsoleInputHandler;
import com.storeware.calculator.infrastructure.input.FileInputHandler;
import com.storeware.calculator.infrastructure.output.ConsoleFileOutputHandler;
import com.storeware.calculator.infrastructure.output.ConsoleOutputHandler;
import com.storeware.calculator.infrastructure.output.FileOutputHandler;
import com.storeware.calculator.util.ConsolePrinter;
import com.storeware.calculator.util.ConsoleReader;

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
