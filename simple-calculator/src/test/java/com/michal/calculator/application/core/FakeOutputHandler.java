package com.michal.calculator.application.core;

import com.michal.calculator.application.port.out.OutputStrategy;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
class FakeOutputHandler implements OutputStrategy {

    public String result;

    @Override
    public void handleResult(String result) {
        this.result = result;
    }
}
