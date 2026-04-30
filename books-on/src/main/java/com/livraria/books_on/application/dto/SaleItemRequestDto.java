package com.livraria.books_on.application.dto;

import java.util.UUID;

public record SaleItemRequestDto(UUID bookId, Integer quantity) {
}
