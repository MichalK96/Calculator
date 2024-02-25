package com.michal.calculator.api.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "math_operation")
@NoArgsConstructor
@Getter
@Setter
public class MathOperationDAO {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(unique = true)
    private String userName;
    private String title;
    @JsonManagedReference
    @OneToMany(mappedBy = "mathOperation", cascade = CascadeType.ALL)
    private List<ExpressionDAO> expressions;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "math_result_id", referencedColumnName = "id")
    private MathResultDAO mathResult;
}

