package com.escola.escola_projeto.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tb_grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Enrollment enrollment;

    private Double grade;

    public Grade(){
        this.id = UUID.randomUUID();
    }
}
