package com.michal.calculator.util;

public class ConsoleUtil {

    public static boolean userConfirmation(String message) {
        ConsolePrinter.printInfo(message);
        var confirm = ConsoleReader.consoleReadString();
        if (confirm.equals("y")) {
            return true;
        } else if (confirm.equals("n")) {

            return false;
        }
        ConsolePrinter.printWarn("Provide correct value");
        return userConfirmation("");
    }

    public static String getUserInput(String message) {
        ConsolePrinter.printInfo(message);
        return ConsoleReader.consoleReadString();
    }

}
