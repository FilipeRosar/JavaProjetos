package com.livraria.books_on.domain.repository;

import com.livraria.books_on.domain.entity.Author;
import com.livraria.books_on.domain.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository  extends JpaRepository<Publisher, UUID> {
}
