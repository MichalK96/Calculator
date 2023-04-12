package com.storeware.calculator.input;

import java.util.Scanner;

public class ConsoleReader {

    private ConsoleReader() {
        throw new IllegalStateException("Utility class");
    }

    public static String consoleReadString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}