package com.storeware.calculator.infrastructure.input;

import com.storeware.calculator.util.ConsolePrinter;
import com.storeware.calculator.util.ConsoleReader;
import com.storeware.calculator.infrastructure.Expression;
import com.storeware.calculator.application.port.in.InputStrategy;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class FileInputHandler implements InputStrategy {

    String filePath = "input.txt";

    private List<Expression> readFile() {
        List<Expression> mathematicalOperations = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(provideFilePath()))){
            while (scanner.hasNextLine()) {
                mathematicalOperations.add(LineExpressionConverter.createExpression(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            ConsolePrinter.printError("An error occurred, file not found");
            e.printStackTrace();
        }
        return mathematicalOperations;
    }

    private String provideFilePath() {
        ConsolePrinter.printInfo("Do you want to use the default file? (y/n)");
        if (ConsoleReader.consoleReadString().equals("y")) {
            return filePath;
        } else {
            ConsolePrinter.printInfo("Provide file path");
            filePath = ConsoleReader.consoleReadString();
            return filePath;
        }
    }

    @Override
    public List<Expression> readInput() {
        return readFile();
    }



}
