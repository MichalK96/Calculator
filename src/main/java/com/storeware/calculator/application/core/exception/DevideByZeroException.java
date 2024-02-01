package com.storeware.calculator.application.core.exception;

public class DevideByZeroException extends RuntimeException {

    public DevideByZeroException() {
        super("Division by zero is not allowed");
    }

    public DevideByZeroException(String message) {
        super(message);
    }
}
