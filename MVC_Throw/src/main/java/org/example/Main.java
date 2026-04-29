package example;

import example.controller.AlunoController;
import example.model.Aluno;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            AlunoController controller = new AlunoController();
            System.out.println("Informe o nome do aluno: ");
            String nome = sc.nextLine();

            System.out.println("Informe a 1º nota: ");
            double nota1 = sc.nextDouble();

            System.out.println("Informe a 2º nota: ");
            double nota2 = sc.nextDouble();

            Aluno aluno = controller.criarAluno(nome, nota1, nota2);

            System.out.println("====RESULTADO====");
            System.out.println(controller.exibirDados(aluno));

        } catch (RuntimeException e) {
            System.out.println("Dados invalidos: " + e.getMessage());
            ;
        }
    }
}