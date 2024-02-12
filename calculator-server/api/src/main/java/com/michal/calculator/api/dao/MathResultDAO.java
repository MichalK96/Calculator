package com.michal.calculator.api.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "math_result")
@NoArgsConstructor
@Getter
@Setter
public class MathResultDAO {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private BigDecimal result;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "math_operation_id")
    private MathOperationDAO mathOperation;

}
