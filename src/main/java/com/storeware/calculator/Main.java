package com.storeware.calculator;

import com.storeware.calculator.calculator.Calculator;
import com.storeware.calculator.input.FileReader;
import com.storeware.calculator.output.ConsoleMessage;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        FileReader fileReader = new FileReader();

        int result = calculator.calculateSetOfOperations(fileReader.readFile());
        ConsoleMessage.displayResult(result);

    }
}