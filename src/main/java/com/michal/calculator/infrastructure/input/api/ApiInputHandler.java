package com.michal.calculator.infrastructure.input.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.infrastructure.Expression;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ApiInputHandler implements InputStrategy {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Expression> readInput() {
        String response = restTemplate.getForObject("http://localhost:8080/api/math-operations", String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<ApiMathOperation> mathOperation = objectMapper.readValue(response, new TypeReference<List<ApiMathOperation>>() {});
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return null;        // TODO to implement
    }

}
