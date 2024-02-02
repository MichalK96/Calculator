package com.storeware.calculator.infrastructure.input;

import com.storeware.calculator.infrastructure.Expression;
import com.storeware.calculator.application.port.in.InputStrategy;
import com.storeware.calculator.util.ConsolePrinter;
import com.storeware.calculator.util.ConsoleReader;

import java.util.ArrayList;
import java.util.List;

public class ConsoleInputHandler implements InputStrategy {
    @Override
    public List<Expression> readInput() {
        var expressions = new ArrayList<Expression>();
        ConsolePrinter.printInfo("Provide single expression");
        while (true) {
            var expression = LineExpressionConverter.createExpression(ConsoleReader.consoleReadString());
            expressions.add(expression);
            if (expression.isStartExpression()) {
                break;
            }
            ConsolePrinter.printInfo("Provide another expression. To finish entering data use APPLY");
        }
        return expressions;
    }
}
