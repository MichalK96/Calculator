package com.michal.calculator.application.port.in;

import com.michal.calculator.infrastructure.Expression;

import java.util.List;

public interface InputStrategy {

    String fileName = null;

    List<Expression> readInput();

    default String getFilePath() {
        return fileName;
    }

}
