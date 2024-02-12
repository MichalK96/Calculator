package com.michal.calculator.infrastructure.output;

import com.michal.calculator.application.port.out.OutputStrategy;
import com.michal.calculator.util.ConsolePrinter;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Setter
public class ApiOutputHandler implements OutputStrategy {

    private final RestTemplate restTemplate = new RestTemplate();
    private String host;
    private String userName;
    private String title;

    @Override
    public void handleResult(String result) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("result", result);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                String.format("http://%s:8080/api/math-operations/save-result/%s/%s", host, userName, title),
                HttpMethod.PUT,
                requestEntity,
                Void.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            ConsolePrinter.printInfo("Result saved successfully.");
        } else {
            ConsolePrinter.printError("Failed to save result.");
        }
    }
}
