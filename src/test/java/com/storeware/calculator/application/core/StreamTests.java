package com.storeware.calculator.application.core;

import com.storeware.calculator.infrastructure.Expression;
import com.storeware.calculator.infrastructure.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class StreamTests {

    private CalculationHandler calculationHandler;

    @BeforeEach
    void setUp() {
        calculationHandler = new CalculationHandler();
    }

//    @Documented
//    @Target(ElementType.METHOD)
//    @Retention(RetentionPolicy.RUNTIME)
//    @ArgumentsSource(VariableArgumentsProvider.class)
//    public @interface VariableSource {
//        String value();
//    }
//
//    static class VariableArgumentsProvider implements ArgumentsProvider,
//            AnnotationConsumer<VariableSource> {
//        private String variableName;
//        @Override
//        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
//
//            return context.getTestClass()
//                    .map(this::getField)
//                    .map(this::getValue)
//                    .orElseThrow(() -> new IllegalArgumentException("Failed to load test arguments"));
//        }
//
//        @Override
//        public void accept(VariableSource variableSource) {
//            variableName = variableSource.value();
//        }
//
//        private Field getField(Class<?> clazz) {
//            try {
//                return clazz.getDeclaredField(variableName);
//            } catch (Exception e) {
//                return null;
//            }
//        }
//
//        @SuppressWarnings("unchecked")
//        private Stream<Arguments> getValue(Field field) {
//            Object value = null;
//            try {
//                value = field.get(null);
//            } catch (Exception ignored) {
//            }
//
//            return value == null ? null : (Stream<Arguments>) value;
//        }
//    }
//
//    public static Stream<Arguments> nullArgument = Stream.of(
//            Arguments.of(null, null));
//    @ParameterizedTest
//    @VariableSource("nullArgument")
//    @DisplayName("When argument is null then should return NullPointerException")
//    void When_ArgumentIsNull_Then_ShouldReturnNull(List<Expression> arg, Exception expected) {
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        PrintStream errorStream = System.err;
//        System.setErr(new PrintStream(outputStream));
//        try {
//            assertEquals(expected, calculationHandler.count(arg));
//        } finally {
//            System.setErr(errorStream);
//        }
////        assertThat(exception).isInstanceOf(expected);
//    }
//
//    public static Stream<Arguments> correctArgument = Stream.of(
//            Arguments.of(null, 10.0));
//    @ParameterizedTest
//    @VariableSource("correctArgument")
//    @DisplayName("When argument is null then should return NullPointerException")
//    void When_ArgumentIsNull_Then_ShouldReturnNulll(List<Expression> arg, double expected) {
//        //Given
//        var argument = List.of(
//                generateExpression(10.0, Operator.ADD),
//                generateExpression(5.0, Operator.SUBTRACT),
//                generateExpression(5.0, Operator.APPLY)
//        );
//        //When
//        var result = calculationHandler.count(argument);
//        //Then
//        assertEquals(expected, result);
//    }
//
//    private Expression generateExpression(double number, Operator operator) {
//        return Expression.builder()
//                .number(new BigDecimal(number))
//                .operator(operator)
//                .build();
//    }

}