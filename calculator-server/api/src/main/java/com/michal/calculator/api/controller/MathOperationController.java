package com.michal.calculator.api.controller;

import com.michal.calculator.api.dao.MathOperationDAO;
import com.michal.calculator.api.service.MathOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MathOperationController {

    @Autowired
    private MathOperationService mathOperationService;

    @GetMapping("/math-operations")
    public List<MathOperationDAO> getAllMathOperations() {
        return mathOperationService.getAllExpressions();
    }

    @PostMapping("/math-operations")
    public ResponseEntity<MathOperationDAO> createMathExpression(@RequestBody MathOperationDAO mathOperationDAO) {
        var savedUserExpressions = mathOperationService.save(mathOperationDAO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserExpressions);
    }

    @GetMapping("/math-operations/{userId}/{name}")
    public ResponseEntity<MathOperationDAO> getMathOperationByUserIdAndName(
            @PathVariable String userId,
            @PathVariable String name) {

        var mathOperation = mathOperationService.getMathOperationByUserIdAndName(userId, name);

        if (mathOperation != null) {
            return ResponseEntity.ok(mathOperation);
        }
        return ResponseEntity.notFound().build();
    }

}
