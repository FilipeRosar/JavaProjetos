package com.livraria.books_on.domain.dto.SalesDTOs;

import java.math.BigDecimal;
import java.util.List;

public record SalesReportDto(
        BigDecimal totalRevenue,
        Long totalSales,
        List<TopSellingBookDto> topBooks
) {
}
