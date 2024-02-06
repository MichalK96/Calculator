package com.michal.calculator.infrastructure.input;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.infrastructure.Expression;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiInputHandler implements InputStrategy {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Expression> readInput() {
        return null;        // TODO to implement
    }

    private String response = restTemplate.getForObject("http://localhost:8080/api/math-operations", S)
}
