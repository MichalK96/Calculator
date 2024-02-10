package com.michal.calculator.configuration;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.application.port.out.OutputStrategy;
import com.michal.calculator.infrastructure.input.FileInputHandler;
import com.michal.calculator.infrastructure.input.api.ApiInputHandler;
import com.michal.calculator.infrastructure.output.ApiOutputHandler;
import com.michal.calculator.infrastructure.output.ConsoleFileOutputHandler;
import com.michal.calculator.infrastructure.output.FileOutputHandler;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class CalculatorConfiguration {

    private final InputStrategy inputHandler;
    private final OutputStrategy outputHandler;
    private final Properties properties;

    public static CalculatorConfigurationFactory factory() {
        return new CalculatorConfigurationFactory();
    }

    public static class CalculatorConfigurationFactory {

        private InputStrategy inputStrategy;
        private OutputStrategy outputStrategy;
        private Properties properties;

        public CalculatorConfigurationFactory properties(Properties properties) {
            this.properties = properties;
            return this;
        }

        public CalculatorConfigurationFactory generateInputStrategy() {
            this.inputStrategy = properties.getInputType().getInputStrategy();

            if (inputStrategy instanceof FileInputHandler fileInputStrategy) {
                fileInputStrategy.setFilePath(properties.getFilePath());
            } else if (inputStrategy instanceof ApiInputHandler apiInputHandler) {
                apiInputHandler.setHost(properties.getHost());
            }
            return this;
        }

        public CalculatorConfigurationFactory generateOutputStrategy() {
            this.outputStrategy = properties.getOutputType().getOutputStrategy();

            if (outputStrategy instanceof FileOutputHandler fileOutputHandler) {
                fileOutputHandler.setFilePath(properties.getFilePath());
            } else if (outputStrategy instanceof ConsoleFileOutputHandler consoleFileOutputHandler) {
                consoleFileOutputHandler.setProperties(properties.getFilePath());
            } else if (outputStrategy instanceof ApiOutputHandler apiOutputHandler) {
                apiOutputHandler.setHost(properties.getHost());
                apiOutputHandler.setUserName(properties.getUserName());
            }
            return this;
        }

        public CalculatorConfiguration build() {
            return CalculatorConfiguration.builder()
                    .inputHandler(inputStrategy)
                    .outputHandler(outputStrategy)
                    .build();
        }

    }

}
