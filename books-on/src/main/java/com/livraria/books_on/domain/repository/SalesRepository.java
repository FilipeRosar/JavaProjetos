package com.livraria.books_on.domain.repository;

import com.livraria.books_on.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sale, UUID> {
    @Query("""
            SELECT COALESCE (SUM(s.total),0)
            FROM Sale s
                WHERE DATE(s.saleDate) = :date
            """)
    BigDecimal getDailyRevenue(LocalDate date);

    @Query("""
            SELECT COUNT(s)
            FROM Sale s
            WHERE DATE(s.saleDate) =: date
            """)
    Long getDailySales(LocalDate date);

    @Query("""
            SELECT COALESCE(SUM(s.total),0)
            FROM Sale s
            WHERE YEAR(s.saleDate) = :year
            AND MONTH(s.saleDate) = :month
            """)
    BigDecimal getMouthlyRevenue(Integer year, Integer month);
}
