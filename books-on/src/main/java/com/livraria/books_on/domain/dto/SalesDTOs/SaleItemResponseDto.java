package com.livraria.books_on.domain.dto.SalesDTOs;

import java.math.BigDecimal;
import java.util.UUID;

public record SaleItemResponseDto(UUID bookId,String title, Integer quantity, BigDecimal price) {
}
