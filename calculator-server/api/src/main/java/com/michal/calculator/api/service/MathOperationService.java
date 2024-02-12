package com.michal.calculator.api.service;

import com.michal.calculator.api.dao.MathOperationDAO;
import com.michal.calculator.api.dao.MathResultDAO;
import com.michal.calculator.api.repository.MathOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class MathOperationService {

    @Autowired
    private MathOperationRepository mathOperationRepository;

    public List<MathOperationDAO> getAllExpressions() {
        return mathOperationRepository.findAll();
    }

    public MathOperationDAO save(MathOperationDAO mathOperation) {
        mathOperation.getExpressions().forEach(expression -> expression.setMathOperation(mathOperation));
        return mathOperationRepository.save(mathOperation);
    }

    public MathOperationDAO getMathOperationByUserIdAndName(String userId, String name) {
        return mathOperationRepository.findByUserNameAndTitle(userId, name);
    }

    public MathOperationDAO saveResult(String result, String userName, String title) {
        var mathOperation = mathOperationRepository.findByUserNameAndTitle(userName, title);
        var mathResult = new MathResultDAO();
        mathResult.setResult(new BigDecimal(result));
        mathOperation.setMathResult(mathResult);
        return mathOperationRepository.save(mathOperation);
    }

}
