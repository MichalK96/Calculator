package com.michal.calculator.configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Properties {

    private InputType inputType;
    private OutputType outputType;
    private String filePath = "input.txt";
    private String host = "localhost";
    private String userName;
    private String title;


}
