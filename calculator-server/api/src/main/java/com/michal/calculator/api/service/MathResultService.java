package com.michal.calculator.api.service;

import com.michal.calculator.api.dao.MathResultDAO;
import com.michal.calculator.api.repository.MathResultRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MathResultService {

    @Autowired
    private MathResultRepository mathResultRepository;

    public MathResultDAO save(MathResultDAO mathResultDAO) {

        return mathResultRepository.save(mathResultDAO);
    }

}
