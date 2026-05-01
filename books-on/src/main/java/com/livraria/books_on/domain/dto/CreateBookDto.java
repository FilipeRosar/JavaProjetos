package com.livraria.books_on.domain.dto;

import com.livraria.books_on.domain.entity.Author;
import com.livraria.books_on.domain.entity.Publisher;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateBookDto(String ISBN,
                            String title,
                            UUID authorId,
                            UUID publisherId,
                            BigDecimal price,
                            Integer stock) {
}
