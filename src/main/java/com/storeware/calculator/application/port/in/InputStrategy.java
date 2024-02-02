package com.storeware.calculator.application.port.in;

import com.storeware.calculator.infrastructure.Expression;

import java.util.List;

public interface InputStrategy {

    String fileName = null;

    List<Expression> readInput();

    default String getFilePath() {
        return fileName;
    }

}
