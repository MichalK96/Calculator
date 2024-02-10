package com.michal.calculator.infrastructure.input;

import com.michal.calculator.infrastructure.Expression;
import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.util.ConsolePrinter;
import com.michal.calculator.util.ConsoleReader;

import java.util.ArrayList;
import java.util.List;

public class ConsoleInputHandler implements InputStrategy {

    @Override
    public List<Expression> readInput() {
        var expressions = new ArrayList<Expression>();
        ConsolePrinter.printInfo("Provide single expression");
        while (true) {
            var expression = LineExpressionConverter.createExpression(ConsoleReader.consoleReadString());
            if (expression.isEndExpression()) {
                break;
            }
            expressions.add(expression);
            ConsolePrinter.printInfo("Provide another expression. To finish entering data use DONE");
        }
        return expressions;
    }
}
