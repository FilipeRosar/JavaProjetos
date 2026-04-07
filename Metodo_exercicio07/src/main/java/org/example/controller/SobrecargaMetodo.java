package org.example.controller;

public class SobrecargaMetodo {
    private int idade;
    private String nome;

    public SobrecargaMetodo(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
        System.out.println("Idade: " + idade + "- Nome: " + nome);
    }

    public SobrecargaMetodo() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        System.out.println("Nome: " + getNome());
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
        System.out.println("Idade: " + getIdade());

    }
}
