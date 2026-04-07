package org.controller;

import java.util.Scanner;

public class ExemploInteiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Entre com o primeiro valor: ");
        int primeiroValor = sc.nextInt();

        System.out.println("Entre com o segundo valor: ");
        int segundoValor = sc.nextInt();

        valoresCalculo(primeiroValor,segundoValor);

    }
    public static int valoresCalculo(int numeroUm, int numeroDois){
        int opcao, resultado = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. +\n" +
                "2. -\n" +
                "3. x");

        opcao = sc.nextInt();


        switch (opcao) {
            case 1:
                resultado = soma(numeroUm,numeroDois);
                System.out.print(numeroUm +" + "+ numeroDois + " = "+resultado);
                break;
            case 2:
                resultado = subtracao(numeroUm,numeroDois);
                System.out.print(numeroUm +" - "+ numeroDois + " = "+resultado);
                break;
            case 3:
                resultado = multiplicaco(numeroUm,numeroDois);
                System.out.print(numeroUm +" x "+ numeroDois + " = "+resultado);
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
        return resultado;


    }
    public static int soma(int numeroUm, int numeroDois){
        return numeroUm + numeroDois;
    }
    public static int subtracao(int numeroUm, int numeroDois){
        return numeroUm - numeroDois;
    }
    public static int multiplicaco(int numeroUm, int numeroDois){
        return numeroUm * numeroDois;
    }
}
