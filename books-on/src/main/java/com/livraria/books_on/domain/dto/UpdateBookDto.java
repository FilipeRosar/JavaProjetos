package com.livraria.books_on.domain.dto;

import java.math.BigDecimal;

public record UpdateBookDto(String title, String author, BigDecimal price, Integer stock) {
}
