package com.storeware.calculator.input;

import com.storeware.calculator.output.ConsoleMessage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    String fileName = "input.txt";

    public List<String> readFile() {
        List<String> mathematicalOperations = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(provideFilePath()))){
            while (scanner.hasNextLine()) {
                mathematicalOperations.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            ConsoleMessage.displayError("An error occurred");
            e.printStackTrace();
        }
        if (!checkCorrectKeyword(mathematicalOperations.get(mathematicalOperations.size() - 1))) {
            throw new IllegalArgumentException("Provide correct end of statement");
        }
        return mathematicalOperations;
    }

    private String provideFilePath() {
        ConsoleMessage.displayMessage("Do you want to use the default file? (y/n)");
        if (ConsoleReader.consoleReadString().equals("y")) {
            return fileName;
        } else {
            ConsoleMessage.displayMessage("Provide file path");
            return ConsoleReader.consoleReadString();
        }
    }

    private boolean checkCorrectKeyword(String expression) {
        return expression.startsWith("apply ");
    }


}