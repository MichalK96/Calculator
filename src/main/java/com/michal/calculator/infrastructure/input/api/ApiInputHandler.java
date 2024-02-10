package com.michal.calculator.infrastructure.input.api;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.infrastructure.Expression;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Setter
public class ApiInputHandler implements InputStrategy {

    private final RestTemplate restTemplate = new RestTemplate();
    private String host;

    @Override
    public List<Expression> readInput() {
        var response = restTemplate.getForObject(String.format("http://%s:8080/api/math-operations", host), ApiMathOperation[].class);
        assert response != null;
        return response[0].getExpressions();
    }
}
