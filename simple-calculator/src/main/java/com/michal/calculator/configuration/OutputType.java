package com.michal.calculator.configuration;

import com.michal.calculator.application.port.out.OutputStrategy;
import com.michal.calculator.infrastructure.output.ApiOutputHandler;
import com.michal.calculator.infrastructure.output.ConsoleFileOutputHandler;
import com.michal.calculator.infrastructure.output.ConsoleOutputHandler;
import com.michal.calculator.infrastructure.output.FileOutputHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OutputType {

    CONSOLE(new ConsoleOutputHandler()),
    FILE(new FileOutputHandler()),
    CONSOLE_FILE(new ConsoleFileOutputHandler()),
    API(new ApiOutputHandler());

    private final OutputStrategy outputStrategy;

}
