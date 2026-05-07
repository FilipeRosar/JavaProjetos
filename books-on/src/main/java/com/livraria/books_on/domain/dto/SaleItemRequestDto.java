package com.livraria.books_on.domain.dto;

import java.util.UUID;

public record SaleItemRequestDto(UUID bookId, Integer quantity) {
}
