package com.michal.calculator.api.service;

import com.michal.calculator.api.dao.MathOperationDAO;
import com.michal.calculator.api.repository.MathOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathOperationService {

    @Autowired
    private MathOperationRepository mathOperationRepository;

    public List<MathOperationDAO> getAllExpressions() {
        return mathOperationRepository.findAll();
    }

    public List<MathOperationDAO> getByUserAndName() {
        return null;
    }

    public MathOperationDAO save(MathOperationDAO mathOperation) {
        mathOperation.getExpressions().forEach(expression -> expression.setMathOperation(mathOperation));
        return mathOperationRepository.save(mathOperation);
    }

    public MathOperationDAO getMathOperationByUserIdAndName(String userId, String name) {
        return mathOperationRepository.findByUserIdAndName(userId, name);
    }

}
