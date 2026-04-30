package com.livraria.books_on.application.dto.SalesDTOs;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record SaleResponseDto(UUID saleId, BigDecimal total, List<SaleItemResponseDto> items) {
}
