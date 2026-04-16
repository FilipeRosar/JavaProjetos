package com.livraria.books_on.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    private Double price;
    private int quantity;
    private boolean isAvailable;

}
