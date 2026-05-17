package com.livraria.books_on.domain.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date saleDate;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "sale",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItem> items;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData() {
        return saleDate;
    }

    public void setData(Date saleDate) {
        this.saleDate = saleDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }
}
