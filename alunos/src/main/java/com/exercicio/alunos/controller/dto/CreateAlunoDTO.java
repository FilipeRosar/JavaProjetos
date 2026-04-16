package com.exercicio.alunos.controller.dto;

import com.exercicio.alunos.model.enume.Sex;

import java.util.Date;

public record CreateAlunoDTO(String name, String email, String password, Date dataNascimento, String curso, String telefone, Sex sexo) {
}
