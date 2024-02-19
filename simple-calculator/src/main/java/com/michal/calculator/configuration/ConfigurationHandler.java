package com.michal.calculator.configuration;

import com.michal.calculator.util.ConsolePrinter;
import com.michal.calculator.util.ConsoleReader;
import com.michal.calculator.util.ConsoleUtil;

import java.util.regex.Pattern;

public class ConfigurationHandler {

    private static final String HOST_PATTERN = "^(?:(?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$";
    private static final String HOST_PATTERN2_toTestAdnReplace = "^(?:(?!-)[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z]{2,6}$"
            ;
    private static Properties properties;

    private ConfigurationHandler() {}

    public static Properties setProperties() {
        properties = new Properties();
        setInputProperties();
        setOutputProperties();

        return properties;
    }

    private static void setOutputProperties() {
        var value = ConsoleUtil.getUserInput("""
                Where result should be placed
                1 File
                2 Console
                3 File and console
                4 Sent to server
                """);
        switch (value) {
            case "1" -> setFileOutputProperties();
            case "2" -> setConsoleOutputProperties();
            case "3" -> setConsoleFileOutputProperties();
            case "4" -> setApiOutputProperties();
            default -> {
                ConsolePrinter.printWarn("Provide correct value");
                setOutputProperties();
            }
        }
    }

    private static void setFileOutputProperties() {
        properties.setOutputType(OutputType.FILE);
    }

    private static void setConsoleOutputProperties() {
        properties.setOutputType(OutputType.CONSOLE);
    }

    private static void setConsoleFileOutputProperties() {
        properties.setOutputType(OutputType.CONSOLE_FILE);
    }

    private static void setApiOutputProperties() {
        properties.setOutputType(OutputType.API);
    }

    private static void setInputProperties() {
        var userInput = ConsoleUtil.getUserInput("""
                Select data source
                1 File
                2 Enter manually
                3 Fetch from API
                """);
        switch (userInput) {
            case "1" -> setFileInputProperties();
            case "2" -> setConsoleInputProperties();
            case "3" -> setApiInputProperties();
            default -> {
                ConsolePrinter.printWarn("Provide correct value");
                setInputProperties();
            }
        }
    }

    private static void setFileInputProperties() {
        properties.setInputType(InputType.FILE);
        var defaultFilePath = ConsoleUtil.userConfirmation("Do you want to use the default file? (y/n)");
        if (!defaultFilePath) {
            ConsolePrinter.printInfo("Provide file path");
            properties.setFilePath(ConsoleReader.consoleReadString());
        }
    }

    private static void setConsoleInputProperties() {
        properties.setInputType(InputType.CONSOLE);
    }

    private static void setApiInputProperties() {
        properties.setInputType(InputType.API);
        var localhost = ConsoleUtil.userConfirmation("Dou you want to use localhost?");
        if (!localhost) {
            properties.setHost(getHost());
        }
        properties.setUserName(ConsoleUtil.getUserInput("Provide user name"));
        properties.setTitle(ConsoleUtil.getUserInput("Math expression title"));
    }

    private static String getHost() {
        var host = ConsoleUtil.getUserInput("Provide host");
        if (isValidHost(host)) {
            return host;
        }
        ConsolePrinter.printWarn("Incorrect value");
        return getHost();
    }

    private static boolean isValidHost(String host) {
        var pattern = Pattern.compile(HOST_PATTERN);
        var matcher = pattern.matcher(host);
        return matcher.matches();
    }

}
