package com.michal.calculator.infrastructure.output;

import com.michal.calculator.application.port.out.OutputStrategy;

import java.math.BigDecimal;

public class ConsoleFileOutputHandler implements OutputStrategy {

    private final FileOutputHandler fileOutputHandler = new FileOutputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

    @Override
    public void handleResult(String result, String filePath) {
        fileOutputHandler.handleResult(result, filePath);
        consoleOutputHandler.handleResult(result, filePath);
    }
}
