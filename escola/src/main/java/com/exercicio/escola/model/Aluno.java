package com.exercicio.escola.model;


import lombok.Generated;

import java.util.Date;
import java.util.UUID;


public class Aluno {
    @Generated
    private UUID id;
    private String name;
    private String telefone;
    private String cpf;
    private Date dataNascimento;
    private String matricula;

    public Aluno(){}

    public Aluno( String name, String telefone, String cpf, Date dataNascimento, String matricula){
        this.name = name;
        this.telefone = telefone;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public  void mostrarAluno(){

    }
}
