package com.livraria.books_on.domain.dto.authorDTOs;

import java.util.UUID;

public record AuthorResponseDto(
        UUID id,
        String name
) {
}
