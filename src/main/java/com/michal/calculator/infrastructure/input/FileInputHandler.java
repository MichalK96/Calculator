package com.michal.calculator.infrastructure.input;

import com.michal.calculator.util.ConsolePrinter;
import com.michal.calculator.util.ConsoleReader;
import com.michal.calculator.infrastructure.Expression;
import com.michal.calculator.application.port.in.InputStrategy;
import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class FileInputHandler implements InputStrategy {

    String filePath = "input.txt";
    String lineForm = "\\w+\\s[\\d.,]+";

    private List<Expression> readFile() {
        List<Expression> mathematicalOperations = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(provideFilePath()))){
            while (scanner.hasNextLine()) {
                var line = scanner.nextLine();
                if (!isLineValid(line)) {
                    break;
                }
                mathematicalOperations.add(LineExpressionConverter.createExpression(line));
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

    private boolean isLineValid(String line) {
        Pattern pattern = Pattern.compile(lineForm);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }

    @Override
    public List<Expression> readInput() {
        return readFile();
    }



}
