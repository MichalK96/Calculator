package com.storeware.calculator;

import com.storeware.calculator.port.in.InputStrategy;
import com.storeware.calculator.port.out.OutputStrategy;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class CalculatorResources {

    private final InputStrategy inputHandler;
    private final OutputStrategy outputHandler;

    public static CalculatorResourcesFactory factory() {
        return new CalculatorResourcesFactory();
    }

    static class CalculatorResourcesFactory {

        private InputStrategy inputStrategy;
        private OutputStrategy outputStrategy;

        public CalculatorResourcesFactory inputStrategy(InputStrategy inputStrategy) {
            this.inputStrategy = inputStrategy;
            return this;
        }

        public CalculatorResourcesFactory outputStrategy(OutputStrategy outputStrategy) {
            this.outputStrategy = outputStrategy;
            return this;
        }

        public CalculatorResources build() {
            return CalculatorResources.builder()
                    .inputHandler(inputStrategy)
                    .outputHandler(outputStrategy)
                    .build();
        }

    }

}
