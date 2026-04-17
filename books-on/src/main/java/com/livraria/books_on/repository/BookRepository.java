package com.livraria.books_on.repository;

import com.livraria.books_on.domain.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BookRepository extends JpaRepository<Books, UUID> {
}
