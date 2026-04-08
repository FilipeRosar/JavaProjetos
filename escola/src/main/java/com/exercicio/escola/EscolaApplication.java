package com.exercicio.escola;

import com.exercicio.escola.model.Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EscolaApplication {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		List<Aluno> alunosLista = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		for (int i = 0; i < 3; i++) {

			System.out.println("Digite o nome do "+(i + 1)+"° aluno: ");
			String alunoName = sc.next();

			System.out.println("Digite o telefone do "+(i + 1)+"° aluno: ");
			String alunoTelefone = sc.next();

			System.out.println("Digite o CPF do "+(i + 1)+"° aluno: ");
			String alunoCPF = sc.next();

			System.out.println("Digite a data de nascimento do "+(i + 1)+" (dd/MM/yyyy): ");
			String dataStr = sc.next();
			Date dateNascimento = sdf.parse(dataStr);

			System.out.println("Digite a matricula do "+(i + 1)+"° aluno: ");
			String alunoMatricula = sc.next();

			Aluno aluno = new Aluno(alunoName,alunoTelefone,alunoCPF,dateNascimento ,alunoMatricula);

			alunosLista.add(aluno);

		}
		System.out.println("==========///ALUNOS///=======");

		for (Aluno aluno : alunosLista){
			System.out.println("Nome: " + aluno.getName());
			System.out.println("Telefone: " + aluno.getTelefone());
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("Data Nascimento: " + aluno.getDataNascimento());
			System.out.println("Matricula: " + aluno.getMatricula()+"\n");
		}
		sc.close();

	}

}
