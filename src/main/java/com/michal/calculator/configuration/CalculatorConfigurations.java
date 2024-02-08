package com.michal.calculator.configuration;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.application.port.out.OutputStrategy;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class CalculatorConfigurations {

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
            return this;
        }

        public CalculatorConfigurationFactory generateOutputStrategy() {
            this.outputStrategy = properties.getOutputType().getOutputStrategy();
            return this;
        }

        public CalculatorConfigurations build() {
            return CalculatorConfigurations.builder()
                    .inputHandler(inputStrategy)
                    .outputHandler(outputStrategy)
                    .build();
        }

    }

}
