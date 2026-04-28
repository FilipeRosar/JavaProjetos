package com.livraria.books_on.application.controller;

import com.livraria.books_on.domain.dto.CreateBookDto;
import com.livraria.books_on.domain.entity.Books;
import com.livraria.books_on.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/books")
public class BookController {

    @Autowired
    private BookService _bookService;

    @GetMapping("{bookId}")
    public ResponseEntity<Books> getBookById(UUID id){
        var bookId = _bookService.getBookById(id);
        return ResponseEntity.of(bookId);
    }
    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){
        var books = _bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
    @PostMapping
    public ResponseEntity<Books> createBooks(@RequestBody @Valid CreateBookDto dto){
        var bookId = _bookService.createBook(dto);
        return ResponseEntity.created(URI.create("v1/books/"+ bookId.toString())).build();
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBookById( UUID id){
         _bookService.deleteById(id);
         return ResponseEntity.noContent().build();

    }
}
