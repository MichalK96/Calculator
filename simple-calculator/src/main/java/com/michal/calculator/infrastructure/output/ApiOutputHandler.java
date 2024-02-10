package com.michal.calculator.infrastructure.output;

import com.michal.calculator.application.port.out.OutputStrategy;
import lombok.Setter;

@Setter
public class ApiOutputHandler implements OutputStrategy {

    private String host;
    private String userName;

    @Override
    public void handleResult(String result) {
        // TODO to implement
    }
}
