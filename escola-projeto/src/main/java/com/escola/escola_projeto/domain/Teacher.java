package com.escola.escola_projeto.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;
    private String email;
    private String specialty;
    @OneToMany(mappedBy = "teacher")
    private List<ClassGroup> classes;

    public Teacher() {
        this.id = UUID.randomUUID();
    }
}
