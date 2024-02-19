package com.michal.calculator.api.controller;

import com.michal.calculator.api.service.MathResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MathResultController {

    @Autowired
    MathResultService mathResultService;

}
