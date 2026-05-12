package com.livraria.books_on.application.service;

import com.livraria.books_on.domain.dto.UpdateBookDto;
import com.livraria.books_on.domain.dto.CreateBookDto;
import com.livraria.books_on.domain.entity.Book;
import com.livraria.books_on.domain.repository.AuthorRepository;
import com.livraria.books_on.domain.repository.PublisherRepository;
import com.livraria.books_on.infrastructure.exception.BussinessException;
import com.livraria.books_on.domain.repository.BookRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = "products", allEntries = true)
    public UUID createBook(CreateBookDto dto){
        var author = _authorResitory.findById(dto.authorId())
                .orElseThrow(() -> new BussinessException("Autor não encontrado"));
        var publisher = _pushisherResitory.findById(dto.publisherId())
                .orElseThrow(() -> new BussinessException("Editora não encontrada"));

        Book book = new Book();
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setISBN(dto.ISBN());
        book.setTitle(dto.title());
        book.setPrice(dto.price());
        book.setStock(dto.stock());
        book.setAvailable(dto.stock() > 0);

        return _bookResitory.save(book).getBookId();
    }

    @Cacheable(value = "product", key = "#id")
    public Optional<Book> getBookById(UUID id){

        return _bookResitory.findById(id);
    }
    @Cacheable(value = "products")
    public List<Book> getAllBooks(){
        System.out.println("Buscando todos os livros");

        return _bookResitory.findAll();
    }

    public void updateBook(UUID bookId, UpdateBookDto dto){

        var entityBook = _bookResitory.findById(bookId)
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

    public void deleteById(UUID bookId){
        if (bookId == null) {
            throw new BussinessException("O id não pode ser nulo");
        }


        if (!_bookResitory.existsById(bookId)) {
            throw new BussinessException("Livro não encontrado");
        }
        _bookResitory.deleteById(bookId);

    }
}

