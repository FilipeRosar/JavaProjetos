package com.livraria.books_on.application.dto;

import com.livraria.books_on.domain.entity.Author;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record UpdateBookDto(String title, Author author, BigDecimal price, Integer stock) {
}
