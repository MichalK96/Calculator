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

    public static void displayManual() {
        ConsolePrinter.printInfo("Do you want to read the manual (y/n)");
        if (ConsoleReader.userConfirm()) {
            ConsolePrinter.printInfo("""
                    \n\nYou can provide data for calculator manually, use default input.txt file or provide path to your own txt file
                    For result you can select display in console, write to provided previously file (not supported for manually data providing) or both
                    
                    The calculator does not support the order of operations
                    
                    Providing data instruction
                    Calculator has five operators:
                    APPLY, ADD, SUBTRACT, MULTIPLY, DIVIDE, DONE
                    
                    use APPLY with first number to start sequence (apply 10.5)
                    add another operators with numbers to your calculations (divide 2)
                    when you finish provide done (not required for txt files)
                    """);
        }
    }

}
