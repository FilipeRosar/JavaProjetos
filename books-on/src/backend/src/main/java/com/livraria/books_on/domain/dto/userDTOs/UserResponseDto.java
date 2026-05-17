package com.livraria.books_on.domain.dto.userDTOs;

import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String nome
) {
}
