package com.livraria.books_on.application.controller;


import com.livraria.books_on.application.service.AuthorService;
import com.livraria.books_on.domain.dto.authorDTOs.CreateAuthorDto;
import com.livraria.books_on.domain.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/author")
public class AuthorController {

    private final AuthorService _authorService;

    public AuthorController(AuthorService _authorService) {
        this._authorService = _authorService;
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable UUID authorId){
        var id = _authorService.getAuthorById(authorId);
        return ResponseEntity.of(id);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthor(){
        var allAuthor = _authorService.getAllAuthor();
        return ResponseEntity.ok(allAuthor);
    }
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody CreateAuthorDto dto){
        var authorId = _authorService.createAuthor(dto);
        return ResponseEntity.created(URI.create("v1/author/"+authorId.toString())).build();
    }


}
