package com.livraria.books_on.domain.repository;

import com.livraria.books_on.domain.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BookRepository extends JpaRepository<Books, UUID> {
}
