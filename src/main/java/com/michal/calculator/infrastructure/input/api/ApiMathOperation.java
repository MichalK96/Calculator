package com.michal.calculator.infrastructure.input.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class ApiMathOperation {

    private String userId;
    private String name;
    private Set<ApiExpression> expressions;

}
