package com.exercicio.alunos.repository;

import com.exercicio.alunos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface IAlunoRepository extends JpaRepository <Aluno, UUID> {
}
