package com.livraria.books_on.domain.repository;

import com.livraria.books_on.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
