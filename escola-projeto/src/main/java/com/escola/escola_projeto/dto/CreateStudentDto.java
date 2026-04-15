package com.escola.escola_projeto.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public record CreateStudentDto(
        @NotBlank
        String name,
        @NotNull
        @Past
        LocalDate birthDate,
        @Email
        String email,
        String phone
) {
}
