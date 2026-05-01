package com.livraria.books_on.domain.dto.SalesDTOs;

import com.livraria.books_on.domain.dto.SaleItemRequestDto;

import java.util.List;
import java.util.UUID;

public record CreateSaleRequestDto(UUID userId, List<SaleItemRequestDto> items) {
}
