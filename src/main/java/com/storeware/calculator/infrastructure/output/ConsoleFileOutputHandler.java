package com.storeware.calculator.infrastructure.output;

import com.storeware.calculator.application.port.out.OutputStrategy;
import com.storeware.calculator.util.ConsolePrinter;

import java.math.BigDecimal;

public class ConsoleFileOutputHandler implements OutputStrategy {

    private final FileOutputHandler fileOutputHandler = new FileOutputHandler();
    private final ConsoleOutputHandler consoleOutputHandler = new ConsoleOutputHandler();

    @Override
    public void handleResult(BigDecimal result, String filePath) {
        fileOutputHandler.handleResult(result, filePath);
        consoleOutputHandler.handleResult(result, filePath);
    }
}
