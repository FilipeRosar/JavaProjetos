package org.example;

import org.example.controller.SobrecargaMetodo;

public class Main {
    public static void main(String[] args) {
        SobrecargaMetodo perfil = new SobrecargaMetodo();

        perfil.setIdade(25);
        perfil.setNome("Fulano");

        perfil.getNome();
    }
}