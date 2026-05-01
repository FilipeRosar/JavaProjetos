package com.livraria.books_on.domain.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Builder
@Entity
@Table(name = "tb_books")
@Getter
@Setter
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID bookId;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private Date publishedAt;
    @ManyToOne
    @JoinColumn(name = "pushisher_id")
    private Publisher publisher;
    private BigDecimal price;
    private Integer stock;
    private boolean isAvailable;
    private String ISBN;


}
