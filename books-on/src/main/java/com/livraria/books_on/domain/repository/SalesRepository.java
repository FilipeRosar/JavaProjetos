package com.livraria.books_on.domain.repository;

import com.livraria.books_on.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalesRepository extends JpaRepository<Sale, UUID> {
}
