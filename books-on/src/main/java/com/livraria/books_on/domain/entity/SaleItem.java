package com.livraria.books_on.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_saleItems")
@Getter @Setter
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Books book;

    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    private Sale sale;
}
