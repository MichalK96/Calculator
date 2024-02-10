package com.michal.calculator.infrastructure.input.api;

import com.michal.calculator.infrastructure.Expression;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
class ApiMathOperation {

    private String userId;
    private String name;
    private List<Expression> expressions;

}
