package com.storeware.calculator.infrastructure.output;

import com.storeware.calculator.application.port.out.OutputStrategy;
import com.storeware.calculator.util.ConsolePrinter;

import java.math.BigDecimal;

public class ConsoleOutputHandler implements OutputStrategy {

    @Override
    public void handleResult(BigDecimal result, String filePath) {
        ConsolePrinter.printWarn(String.format("\nResult: %s\n", result));
    }
}
