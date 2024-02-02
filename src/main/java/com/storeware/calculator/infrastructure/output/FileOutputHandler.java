package com.storeware.calculator.infrastructure.output;

import com.storeware.calculator.application.port.out.OutputStrategy;
import com.storeware.calculator.util.ConsolePrinter;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

@Setter
public class FileOutputHandler implements OutputStrategy {

    @Override
    public void handleResult(BigDecimal result, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(String.format("\n\nResult: %s", result));
            ConsolePrinter.printInfo("The file has been saved successfully");
        } catch (IOException e) {
            ConsolePrinter.printError("Error while saving to the file: " + e.getMessage());
        }    }
}
