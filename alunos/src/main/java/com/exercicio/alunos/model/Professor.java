package com.exercicio.alunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class Professor {
    @Id
    private UUID Id;
    private String name;

}
