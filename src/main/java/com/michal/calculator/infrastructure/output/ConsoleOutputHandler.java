package com.michal.calculator.infrastructure.output;

import com.michal.calculator.application.port.out.OutputStrategy;
import com.michal.calculator.util.ConsolePrinter;

import java.math.BigDecimal;

public class ConsoleOutputHandler implements OutputStrategy {

    @Override
    public void handleResult(String result, String filePath) {
        ConsolePrinter.printWarn(String.format("\nResult: %s\n", result));
    }
}
