package com.michal.calculator.application.port.out;

import java.math.BigDecimal;

public interface OutputStrategy {

    public void handleResult(String result);

}
