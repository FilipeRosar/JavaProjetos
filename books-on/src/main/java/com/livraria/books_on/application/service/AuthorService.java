package com.livraria.books_on.application.service;


import com.livraria.books_on.domain.dto.authorDTOs.AuthorResponseDto;
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

    public Optional<AuthorResponseDto> getAuthorById(UUID id){
        if (id == null) {
            throw new BussinessException("Autor não existe");
        }

       return  _authorRepository.findById(id).map(this::toDto);
    }
    public List<AuthorResponseDto> getAllAuthor(){
        return _authorRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }
    public UUID createAuthor(CreateAuthorDto dto){
        Author author = new Author();

        author.setName(dto.name());

        return _authorRepository.save(author).getId();
    }
    public void deleteAuthor(UUID id){
        if (id == null) {
            throw new BussinessException("Id não pode ser nulo");
        }
        if (!_authorRepository.existsById(id)){
            throw new BussinessException("Autor não existe");
        }
        _authorRepository.deleteById(id);
    }
    private AuthorResponseDto toDto(Author author){
        return new AuthorResponseDto(
                author.getId(),
                author.getName()
        );
    }
}
