package com.livraria.books_on.application.dto.authDTOs;

import jakarta.validation.constraints.Email;

public record CreateUserDto(String username,
                            String password,
                            @Email String email,
                            String Cpf) {
}
