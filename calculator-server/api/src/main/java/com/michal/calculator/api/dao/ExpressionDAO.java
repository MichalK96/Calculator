package com.michal.calculator.api.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.michal.calculator.api.enums.Operator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "expression")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpressionDAO {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private BigDecimal number;
    private Operator operator;
    private UUID mathOperationId;
}
