package com.michal.calculator.infrastructure.output;

import com.michal.calculator.application.port.out.OutputStrategy;

import java.math.BigDecimal;

public class ConsoleFileOutputHandler implements OutputStrategy {

    private final FileOutputHandler fileOutputHandler = new FileOutputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

    @Override
    public void handleResult(String result) {
        fileOutputHandler.handleResult(result);
        consoleOutputHandler.handleResult(result);
    }

    public void setProperties(String filePath) {
        fileOutputHandler.setFilePath(filePath);
    }

}
