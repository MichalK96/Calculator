package com.storeware.calculator.application.core.exception;

public class InvalidQuantityApplyOperatorException extends RuntimeException {

    public InvalidQuantityApplyOperatorException() {
        super("Number of APPLY operator is different than one");
    }

    public InvalidQuantityApplyOperatorException(String message) {
        super(message);
    }
}
