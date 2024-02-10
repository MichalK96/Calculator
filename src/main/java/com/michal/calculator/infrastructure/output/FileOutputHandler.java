package com.michal.calculator.infrastructure.output;

import com.michal.calculator.application.port.out.OutputStrategy;
import com.michal.calculator.util.ConsolePrinter;
import lombok.Setter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

@Setter
public class FileOutputHandler implements OutputStrategy {

    String filePath;

    @Override
    public void handleResult(String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(String.format("\n\nResult: %s", result));
            ConsolePrinter.printInfo("The file has been saved successfully");
        } catch (IOException e) {
            ConsolePrinter.printError("Error while saving to the file: " + e.getMessage());
        }    }
}
