package com.storeware.calculator.application.port.in;

import com.storeware.calculator.infrastructure.Expression;

import java.util.List;

public interface InputStrategy {

    List<Expression> readInput();

}
