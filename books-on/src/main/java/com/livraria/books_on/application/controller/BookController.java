package com.livraria.books_on.application.controller;

import com.livraria.books_on.domain.dto.CreateBookDto;
import com.livraria.books_on.domain.dto.UpdateBookDto;
import com.livraria.books_on.domain.entity.Book;
import com.livraria.books_on.application.service.BookService;
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


    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable UUID bookId) {
        var id = _bookService.getBookById(bookId);
        return ResponseEntity.of(id);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        var books = _bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Book> createBooks(@RequestBody CreateBookDto dto) {
        var bookId = _bookService.createBook(dto);
        return ResponseEntity.created(URI.create("v1/books/" + bookId.toString())).build();
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBookById(@PathVariable UUID bookId) {
        _bookService.deleteById(bookId);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{bookId}")
    public ResponseEntity<Void> updateBookById(@PathVariable UUID bookId, @RequestBody UpdateBookDto dto) {
        _bookService.updateBook(bookId, dto);
        return ResponseEntity.noContent().build();

    }

}
