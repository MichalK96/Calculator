package com.michal.calculator.application.core;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.infrastructure.Expression;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
class FakeInputHandler implements InputStrategy {

    List<Expression> input;

    @Override
    public List<Expression> readInput() {
        return input;
    }

}
