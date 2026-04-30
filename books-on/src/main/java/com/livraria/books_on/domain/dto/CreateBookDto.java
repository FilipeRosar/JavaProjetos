package com.livraria.books_on.domain.dto;

import java.math.BigDecimal;

public record CreateBookDto(String ISBN,
                            String title,
                            String author,
                            String publisher,
                            BigDecimal price,
                            Integer stock) {
}
