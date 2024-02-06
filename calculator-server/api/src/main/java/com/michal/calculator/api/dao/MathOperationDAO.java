package com.michal.calculator.api.dao;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "math_operation")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MathOperationDAO {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String userId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ExpressionDAO> expressions;
}

