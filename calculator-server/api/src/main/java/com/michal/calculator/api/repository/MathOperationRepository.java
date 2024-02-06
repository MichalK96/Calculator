package com.michal.calculator.api.repository;

import com.michal.calculator.api.dao.MathOperationDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MathOperationRepository extends JpaRepository<MathOperationDAO, UUID> {

    MathOperationDAO findByUserIdAndName(String userId, String name);

}
