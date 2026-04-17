package com.livraria.books_on.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_books")
@Getter
@Setter
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookId;
    private String title;
    private String author;
    private Date publishedAt;
    private String publisher;
    private BigDecimal price;
    private Integer stock;
    private boolean isAvailable;
    private String ISBN;
}
