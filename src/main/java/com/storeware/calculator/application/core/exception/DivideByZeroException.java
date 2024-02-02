package com.storeware.calculator.application.core.exception;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("Division by zero is not allowed");
    }

    public DivideByZeroException(String message) {
        super(message);
    }
}
