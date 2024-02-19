package com.michal.calculator.api.service;

import com.michal.calculator.api.repository.MathResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MathResultService {

    @Autowired
    private MathResultRepository mathResultRepository;

}
