package com.michal.calculator.configuration;

import com.michal.calculator.application.port.in.InputStrategy;
import com.michal.calculator.infrastructure.input.ConsoleInputHandler;
import com.michal.calculator.infrastructure.input.FileInputHandler;
import com.michal.calculator.infrastructure.input.api.ApiInputHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InputType {

    CONSOLE(new ConsoleInputHandler()),
    FILE(new FileInputHandler()),
    API(new ApiInputHandler());

    private final InputStrategy inputStrategy;

}
