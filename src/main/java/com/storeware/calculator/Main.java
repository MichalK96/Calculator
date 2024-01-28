package com.storeware.calculator;

import com.storeware.calculator.calculator.Calculator;
import com.storeware.calculator.input.FileReader;
import com.storeware.calculator.output.ConsoleMessage;

public class Main {
    public static void main(String[] args) {

        final var calculator = new Calculator();
        final var fileReader = new FileReader();

        var operations = fileReader.readFile();
        var result = calculator.calculateSetOfOperations(operations);
        ConsoleMessage.displayResult(result);

    }
}