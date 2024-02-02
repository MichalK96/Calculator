package com.storeware.calculator.application.port.out;

import java.math.BigDecimal;

public interface OutputStrategy {

    public void handleResult(BigDecimal result, String filePath);

}
