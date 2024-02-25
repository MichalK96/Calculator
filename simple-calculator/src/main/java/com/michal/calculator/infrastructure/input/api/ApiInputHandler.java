package com.michal.calculator.infrastructure.input.api;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.configuration.Properties;
import com.michal.calculator.infrastructure.Expression;
import com.michal.calculator.infrastructure.input.ConsoleInputHandler;
import com.michal.calculator.infrastructure.input.FileInputHandler;
import com.michal.calculator.util.ConsolePrinter;
import com.michal.calculator.util.ConsoleUtil;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Setter
public class ApiInputHandler implements InputStrategy {

    private final RestTemplate restTemplate = new RestTemplate();
    private String host;
    private String userName;
    private String title;

    @Override
    public List<Expression> readInput() {
        var response = restTemplate.getForObject(
                String.format("http://%s:8080/api/math-operations/%s/%s", host, userName, title), ApiMathOperation.class);
        assert response != null;
        return response.getExpressions();
    }

    public void addMathOperation(String userName, String title) {
        if (!ConsoleUtil.userConfirmation("Do you want to create a new math operation?")) {
            return;
        }
        var inputStrategy = getInputStrategy();
        var arithmeticOperations = inputStrategy.readInput();
        var apiMathOperation = generateApiMathOperation(userName, title, arithmeticOperations);
        saveMathOperation(apiMathOperation);
    }

    private void saveMathOperation(ApiMathOperation apiMathOperation) {   //TODO refactor and more tests
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ApiMathOperation> requestEntity = new HttpEntity<>(apiMathOperation, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ApiMathOperation> responseEntity = restTemplate.exchange(
                String.format("http://%s:8080/api/math-operations", host),
                HttpMethod.POST,
                requestEntity,
                ApiMathOperation.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ApiMathOperation createdMathOperation = responseEntity.getBody();
            System.out.println("Utworzono nową operację matematyczną: " + createdMathOperation);
        } else {
            System.err.println("Błąd podczas tworzenia operacji matematycznej: " + responseEntity.getStatusCode());
        }
    }

    private ApiMathOperation generateApiMathOperation(String userName, String title, List<Expression> expressions) {
        var apiMathOperation = new ApiMathOperation();
        apiMathOperation.setUserName(userName);
        apiMathOperation.setTitle(title);
        apiMathOperation.setExpressions(expressions);
        return apiMathOperation;
    }

    private InputStrategy getInputStrategy() {
        InputStrategy inputStrategy;
        var userInput = ConsoleUtil.getUserInput("""
                Select data source
                1 File
                2 Enter manually
                """);
        switch (userInput) {
            case "1" -> inputStrategy = generateFileInputHandler();
            case "2" -> inputStrategy = new ConsoleInputHandler();
            default -> {
                ConsolePrinter.printWarn("Provide correct value");
                return getInputStrategy();
            }
        }
        return inputStrategy;
    }

    private FileInputHandler generateFileInputHandler() {
        var fileInputHandler = new FileInputHandler();
        fileInputHandler.setFilePath(ConsoleUtil.getUserInput("Provide file path or press enter to use default"));
        if (fileInputHandler.getFilePath().isEmpty()) {
            fileInputHandler.setFilePath(new Properties().getFilePath());
        }
        return fileInputHandler;
    }

}
