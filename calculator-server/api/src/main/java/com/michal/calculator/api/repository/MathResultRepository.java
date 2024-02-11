package com.michal.calculator.api.repository;

import com.michal.calculator.api.dao.MathResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MathResultRepository extends JpaRepository<MathResultDAO, UUID> {


}
