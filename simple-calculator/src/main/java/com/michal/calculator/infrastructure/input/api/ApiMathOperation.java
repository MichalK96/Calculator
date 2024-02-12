package com.michal.calculator.infrastructure.input.api;

import com.michal.calculator.infrastructure.Expression;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
class ApiMathOperation {

    private UUID id;
    private String userName;
    private String title;
    private List<Expression> expressions;

}
