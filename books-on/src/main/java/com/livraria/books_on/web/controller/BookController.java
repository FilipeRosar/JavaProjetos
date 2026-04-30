package com.livraria.books_on.web.controller;

import com.livraria.books_on.application.dto.CreateBookDto;
import com.livraria.books_on.application.dto.UpdateBookDto;
import com.livraria.books_on.domain.entity.Books;
import com.livraria.books_on.application.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Books> getBookById(@PathVariable("bookId") UUID bookId){
        return _bookService.getBookById(bookId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Books>> getAllBooks(){
        var result = _bookService.getAllBooks();
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody CreateBookDto dto){
            var id = _bookService.createBook(dto);
            return ResponseEntity.created(URI.create("/v1/books/"+ id.toString())).build();

    }
    @PutMapping("/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable("bookId") UUID bookId,
                                            @RequestBody UpdateBookDto dto){
        _bookService.updateBook(bookId, dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId")  String bookId){
        _bookService.deleteById(bookId);
        return ResponseEntity.noContent().build();
    }

}
