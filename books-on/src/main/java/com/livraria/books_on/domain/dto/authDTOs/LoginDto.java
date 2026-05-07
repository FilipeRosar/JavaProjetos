package com.livraria.books_on.domain.dto.authDTOs;

import jakarta.validation.constraints.Email;

public record LoginDto(@Email String email,
                       String password) {
}
