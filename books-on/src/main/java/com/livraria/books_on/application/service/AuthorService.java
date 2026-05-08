package com.livraria.books_on.application.service;


import com.livraria.books_on.domain.dto.authorDTOs.CreateAuthorDto;
import com.livraria.books_on.domain.entity.Author;
import com.livraria.books_on.domain.entity.Book;
import com.livraria.books_on.domain.repository.AuthorRepository;
import com.livraria.books_on.infrastructure.exception.BussinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    private final AuthorRepository _authorRepository;

    public AuthorService(AuthorRepository _authorRepository) {
        this._authorRepository = _authorRepository;
    }

    public Optional<Author> getAuthorById(UUID id){
        if (id == null) {
            throw new BussinessException("Autor não existe");
        }

       return  _authorRepository.findById(id);
    }
    public List<Author> getAllAuthor(){ return _authorRepository.findAll(); }
    public UUID createAuthor(CreateAuthorDto dto){
        Author author = new Author();

        author.setName(dto.name());

        return _authorRepository.save(author).getId();
    }

}
