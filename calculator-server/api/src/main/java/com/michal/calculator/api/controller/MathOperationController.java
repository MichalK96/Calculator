package com.michal.calculator.api.controller;

import com.michal.calculator.api.dao.MathOperationDAO;
import com.michal.calculator.api.service.MathOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/math-operations")
public class MathOperationController {

    @Autowired
    private MathOperationService mathOperationService;

    @GetMapping()
    public List<MathOperationDAO> getAllMathOperations() {
        return mathOperationService.getAllExpressions();
    }

    @PostMapping()
    public ResponseEntity<MathOperationDAO> createMathExpression(@RequestBody MathOperationDAO mathOperationDAO) {
        var savedMathExpressions = mathOperationService.save(mathOperationDAO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMathExpressions);
    }

    @GetMapping("/{userName}/{title}")
    public ResponseEntity<MathOperationDAO> getMathOperationByUserIdAndName(@PathVariable String userName, @PathVariable String title) {
        var mathOperation = mathOperationService.getMathOperationByUserIdAndName(userName, title);

        if (mathOperation != null) {
            return ResponseEntity.ok(mathOperation);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/save-result/{userName}/{title}")
    public ResponseEntity<MathOperationDAO> saveResult(@PathVariable String userName, @PathVariable String title,
                                                       @RequestBody String result) {
        var updatedMathOperation = mathOperationService.saveResult(result, userName, title);
        return ResponseEntity.ok(updatedMathOperation);
    }

}
