package com.storeware.calculator.output;

public class ConsoleMessage {

    private ConsoleMessage() {
        throw new IllegalStateException("Utility class");
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayResult(int message) {
        System.out.println(message);
    }

    public static void displayError(String errorMessage) {
        System.out.println(errorMessage);
    }

}
