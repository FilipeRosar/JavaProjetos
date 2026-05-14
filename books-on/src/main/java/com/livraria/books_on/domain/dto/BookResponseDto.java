package com.livraria.books_on.domain.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record BookResponseDto(
        UUID id,
        String title,
        String author,
        String publisher,
        Date publishedAt,
        BigDecimal price,
        Integer stock,
        String isbn,
        boolean isAvailable
) {
}
