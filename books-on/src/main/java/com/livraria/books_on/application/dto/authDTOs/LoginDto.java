package com.livraria.books_on.application.dto.authDTOs;

import jakarta.validation.constraints.Email;

public record LoginDto(@Email String email,
                       String password) {
}
