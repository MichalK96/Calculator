package com.storeware.calculator.util;

public class ConsolePrinter {

    public static final String RESET = "\033[0m";

    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String YELLOW_BRIGHT = "\033[1;93m";
    public static final String RED_BOLD = "\033[1;31m";

    private void ConsolePrinter() {}

    public static void printInfo(String message) {
        System.out.println(GREEN_BRIGHT + message + RESET);
    }

    public static void printWarn(String message) {
        System.out.println(YELLOW_BRIGHT + message + RESET);
    }

    public static void printError(String message) {
        System.out.println(RED_BOLD + message + RESET);
    }

}
