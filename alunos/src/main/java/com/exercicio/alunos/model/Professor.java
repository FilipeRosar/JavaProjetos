package com.exercicio.alunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Professor extends BaseEntity{
    private String name;
    private String especialidade;


    public Professor(String especialidade, String name) {
        this.especialidade = especialidade;
        this.name = name;
    }

    public Professor(Instant createdAt, Instant updatedAt, String especialidade, String name) {
        super(createdAt, updatedAt);
        this.especialidade = especialidade;
        this.name = name;
    }
}
