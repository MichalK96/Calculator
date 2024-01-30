package com.storeware.calculator.port.in;

import com.storeware.calculator.core.Expression;

import java.util.List;

public interface InputStrategy {

    List<Expression> readInput();

}
