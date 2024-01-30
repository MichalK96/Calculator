package com.storeware.calculator.infrastructure.output;

import com.storeware.calculator.port.out.OutputStrategy;
import com.storeware.calculator.util.ConsolePrinter;

public class ConsoleMessageOutputHandler implements OutputStrategy {

    @Override
    public void handleResult(double result) {
        ConsolePrinter.printInfo(String.valueOf(result));
    }
}
