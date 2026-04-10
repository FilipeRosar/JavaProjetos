package com.exercicio.alunos.model;

import java.time.LocalDate;
import java.util.Date;

public record CreateAlunoDTO(String name, String email, String password, Date dataNascimento, String curso) {
}
