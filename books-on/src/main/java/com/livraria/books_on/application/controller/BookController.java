package com.livraria.books_on.application.controller;

import com.livraria.books_on.domain.entity.Books;
import com.livraria.books_on.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/books")
public class BookController {

    @Autowired
    private BookService _bookService;

    @GetMapping("{bookId}")
    public ResponseEntity<Books> getBookById(@)

}
