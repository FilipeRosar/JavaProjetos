package com.exercicio.escola.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
public class Professor {
    private UUID id;
    private String nome;
    private String telefone;
    private String registro;
    private Date dataNascimento;

    public Professor(String nome, String telefone, String registro, Date dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.registro = registro;
        this.dataNascimento = dataNascimento;
        this.tamanhoDoPau =  tamanhoDoPau;
    }
}