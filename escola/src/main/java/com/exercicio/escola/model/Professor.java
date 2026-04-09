package com.exercicio.escola.model;

import java.util.Date;
import java.util.UUID;

public class Professor {
    private UUID id;
    private String nome;
    private String telefone;
    private String registro;
    private Date dataNascimento;

    public Professor( String nome, String telefone, String registro, Date dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.registro = registro;
        this.dataNascimento = dataNascimento;
    }

    public Professor() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
