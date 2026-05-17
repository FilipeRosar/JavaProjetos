package com.livraria.books_on.domain.dto.authDTOs;

import jakarta.validation.constraints.Email;

public record CreateUserDto(String username,
                            String password,
                            @Email String email,
                            String cpf) {
}
