package com.exercicio.alunos.model;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Table
@Getter
@Setter
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "curso")
    private String curso;

    public Aluno(String name, String matricula, LocalDate dataNascimento,String email, String curso) {
        this.name = name;
        this.matricula = matricula;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.curso = curso;
    }


}
