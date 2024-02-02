package com.storeware.calculator.configuration;

import com.storeware.calculator.application.port.in.InputStrategy;
import com.storeware.calculator.application.port.out.OutputStrategy;
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

    public static CalculatorConfigurationFactory factory() {
        return new CalculatorConfigurationFactory();
    }

    public static class CalculatorConfigurationFactory {

        private InputStrategy inputStrategy;
        private OutputStrategy outputStrategy;

        public CalculatorConfigurationFactory inputStrategy(InputStrategy inputStrategy) {
            this.inputStrategy = inputStrategy;
            return this;
        }

        public CalculatorConfigurationFactory outputStrategy(OutputStrategy outputStrategy) {
            this.outputStrategy = outputStrategy;
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
