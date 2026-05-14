package com.livraria.books_on.domain.dto.SalesDTOs;

public record TopSellingBookDto(
        String title,
        Long totalSold
) {
}
