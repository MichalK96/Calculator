package com.michal.calculator.api.controller;

import com.michal.calculator.api.dao.MathResultDAO;
import com.michal.calculator.api.service.MathResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MathResultController {

    @Autowired
    MathResultService mathResultService;

    @PostMapping("/math-result")
    public ResponseEntity<MathResultDAO> save(@RequestBody MathResultDAO mathResultDAO) {
        return ResponseEntity.ok(mathResultService.save(mathResultDAO));
    }

}
