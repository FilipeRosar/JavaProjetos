package com.exercicio.alunos.controller.dto;

import java.util.Date;

public record CreateAlunoDTO(String name, String email, String password, Date dataNascimento, String curso) {
}
