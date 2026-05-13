package com.livraria.books_on.domain.dto.publisherDTOs;

import java.util.UUID;

public record PublisherResponseDto(
        UUID id,
        String name
) {
}
