package com.michal.calculator.api.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "math_operation")
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MathOperationDAO {

    @Id
    @JsonIgnore
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private String userId;
    private String name;
    @JsonManagedReference
    @OneToMany(mappedBy = "mathOperation", cascade = CascadeType.ALL)
    private Set<ExpressionDAO> expressions;
}

