package com.michal.calculator.util;

import java.util.Scanner;

public class ConsoleReader {

    private ConsoleReader() {
        throw new IllegalStateException("Utility class");
    }

    public static String consoleReadString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public static boolean userConfirm() {
        var confirmation = consoleReadString();
        if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
            return true;
        } else if (confirmation.equalsIgnoreCase("n") || confirmation.equalsIgnoreCase("no")) {
            return false;
        }
        ConsolePrinter.printWarn("Invalid value, enter yes or no");
        return userConfirm();
    }

}