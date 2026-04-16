package com.exercicio.alunos.model;

import com.exercicio.alunos.model.enume.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Table
@Entity
public class Aluno extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "curso")
    private String curso;

    @Column(name = "telefone")
    private String telefone;

    private boolean isActive;

    @Column(name = "sexo")
    private Sex sex;

    public Aluno() {
        super();
    }


    public Aluno( String name, String matricula, Date dataNascimento, String email, String password, String curso, String telefone, Sex sex) {
        super(createdAt, updatedAt);
        this.name = name;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.password = password;
        this.curso = curso;
        this.telefone = telefone;
        this.sex = sex;
    }

}
