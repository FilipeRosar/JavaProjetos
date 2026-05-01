package com.livraria.books_on.domain.dto;

import com.livraria.books_on.domain.entity.Author;

import java.math.BigDecimal;

public record UpdateBookDto(String title, Author author, BigDecimal price, Integer stock) {
}
