package com.livraria.books_on.domain.dto;

import com.livraria.books_on.domain.entity.Author;
import com.livraria.books_on.domain.entity.Publisher;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public record CreateBookDto(String isbn,
                            String title,
                            UUID authorId,
                            UUID publisherId,
                            String description,
                            String url,
                            String genre,
                            Date publishedAt,
                            BigDecimal price,
                            Integer stock) {
}
