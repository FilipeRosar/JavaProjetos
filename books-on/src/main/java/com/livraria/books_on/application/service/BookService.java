package com.livraria.books_on.application.service;

import com.livraria.books_on.domain.dto.UpdateBookDto;
import com.livraria.books_on.domain.dto.CreateBookDto;
import com.livraria.books_on.domain.entity.Books;
import com.livraria.books_on.domain.repository.AuthorRepository;
import com.livraria.books_on.domain.repository.PublisherRepository;
import com.livraria.books_on.infrastructure.exception.BussinessException;
import com.livraria.books_on.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository _bookResitory;
    private final AuthorRepository _authorResitory;
    private final PublisherRepository _pushisherResitory;

    public BookService(AuthorRepository authorResitory, PublisherRepository pushisherResitory, BookRepository bookResitory) {
        _authorResitory = authorResitory;
        _pushisherResitory = pushisherResitory;
        _bookResitory = bookResitory;
    }

    public UUID createBook(CreateBookDto dto){
        var author = _authorResitory.findById(dto.authorId())
                .orElseThrow(() -> new BussinessException("Autor não encontrado"));
        var publisher = _pushisherResitory.findById(dto.publisherId())
                .orElseThrow(() -> new BussinessException("Editora não encontrada"));

        Books book = new Books();
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setISBN(dto.ISBN());
        book.setTitle(dto.title());
        book.setPrice(dto.price());
        book.setStock(dto.stock());
        book.setAvailable(dto.stock() > 0);

        return _bookResitory.save(book).getBookId();
    }
    public Optional<Books> getBookById(UUID id){

        return _bookResitory.findById(id);
    }
    public List<Books> getAllBooks(){
        return _bookResitory.findAll();
    }

    public void updateBook(UUID bookId, UpdateBookDto dto){
        var id = bookId;

        var entityBook = _bookResitory.findById(id)
                .orElseThrow(() -> new BussinessException("Livro não encontrado"));

        if (dto.title() != null){
            entityBook.setTitle(dto.title());
        }
        if (dto.stock() != null){
            entityBook.setStock(dto.stock());
            entityBook.setAvailable(dto.stock() > 0);
        }
        if (dto.price() != null){
            entityBook.setPrice(dto.price());
        }
            _bookResitory.save(entityBook);
        }

    public void deleteById(String bookId){
        if (bookId == null) {
            throw new BussinessException("O id não pode ser nulo");
        }

        var id = UUID.fromString(bookId);

        if (!_bookResitory.existsById(id)) {
            throw new BussinessException("Livro não encontrado");
        }
        _bookResitory.deleteById(id);

    }
    }

