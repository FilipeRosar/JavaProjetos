package com.livraria.books_on.domain.repository;

import com.livraria.books_on.domain.dto.SalesDTOs.TopSellingBookDto;
import com.livraria.books_on.domain.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface SaleItemRepository extends JpaRepository<SaleItem, UUID> {
    @Query("""
           SELECT new com.livraria.books_on.domain.dto.SalesDTOs.TopSellingBookDto(
            b.title,
            SUM(si.quantity)
           )
           FROM SaleItem si
           JOIN si.book b
           GROUP BY b.title
           ORDER BY SUM(si.quantity) DESC
           """)
    List<TopSellingBookDto> getTopSellingBooks();
}
