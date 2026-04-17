package com.livraria.books_on.service;

import com.livraria.books_on.domain.dto.CreateBookDto;
import com.livraria.books_on.domain.dto.UpdateBookDto;
import com.livraria.books_on.domain.entity.Books;
import com.livraria.books_on.exception.BussinessException;
import com.livraria.books_on.repository.BookRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository _bookResitory;
    @Bean
    public UUID createBook(@NotNull CreateBookDto dto){
        Books book = new Books();

        book.setAuthor(dto.author());
        book.setISBN(dto.ISBN());
        book.setTitle(dto.title());
        book.setPrice(dto.price());
        book.setPublisher(dto.publisher());
        book.setStock(dto.stock());
        return _bookResitory.save(book).getBookId();
    }
    public Optional<Books> getBookById(String id){

        var book = _bookResitory.findById(UUID.fromString(id));
        return book.stream().findFirst();
    }
    public List<Books> getAllBooks(){
        return _bookResitory.findAll();
    }
    public void updateBook(String bookId, UpdateBookDto dto){
        var id = UUID.fromString(bookId);

        var entityBook = _bookResitory.findById(id);

        if(entityBook.isPresent()){
            var book = entityBook.get();
            if (dto.title() != null) {
                book.setTitle(dto.title());
            }
            if (dto.stock() != null){
                book.setStock(dto.stock());
            }
            if (dto.price() != null){
                book.setPrice(dto.price());
            }
            if (dto.author() != null){
                book.setAuthor(dto.author());
            }
            _bookResitory.save(book);
        }

    }
    public void deleteById(UUID id){
        if (id == null) {
            throw new BussinessException("O id não pode ser nulo");
        }
        Books books = _bookResitory.findById(id).orElseThrow(() -> new BussinessException("Livro não encontrado"));

        _bookResitory.deleteById(books.getBookId());
    }
}
