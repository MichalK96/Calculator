package com.michal.calculator.infrastructure.input;

import com.michal.calculator.util.ConsolePrinter;
import com.michal.calculator.util.ConsoleReader;
import com.michal.calculator.infrastructure.Expression;
import com.michal.calculator.application.port.in.InputStrategy;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class FileInputHandler implements InputStrategy {

    private String filePath;
    private final String lineForm = "\\w+\\s[\\d.,]+";

    @Override
    public List<Expression> readInput() {
        return readFile();
    }

    private List<Expression> readFile() {
        List<Expression> mathematicalOperations = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))){
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

    private boolean isLineValid(String line) {
        Pattern pattern = Pattern.compile(lineForm);
        Matcher matcher = pattern.matcher(line);
        return matcher.matches();
    }



}
