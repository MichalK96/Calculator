package com.storeware.calculator.application.core;

import com.storeware.calculator.application.port.out.OutputStrategy;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class FakeOutputHandler implements OutputStrategy {

    public BigDecimal result;

    @Override
    public void handleResult(BigDecimal result, String filePath) {
        this.result = result;
    }
}
