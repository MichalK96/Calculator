package com.storeware.calculator.application.core;

import com.storeware.calculator.application.port.in.InputStrategy;
import com.storeware.calculator.infrastructure.Expression;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
public class FakeInputHandler implements InputStrategy {

    List<Expression> input;

    @Override
    public List<Expression> readInput() {
        return input;
    }

}
