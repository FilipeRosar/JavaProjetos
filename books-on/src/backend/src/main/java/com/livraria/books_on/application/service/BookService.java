package com.livraria.books_on.application.service;

import com.livraria.books_on.domain.dto.BookResponseDto;
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

    private final BookRepository _bookRepository;
    private final AuthorRepository _authorRepository;
    private final PublisherRepository _publisherRepository;

    public BookService(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookRepository bookRepository) {
        _authorRepository = authorRepository;
        _publisherRepository = publisherRepository;
        _bookRepository = bookRepository;
    }
    @CacheEvict(value = "products", allEntries = true)
    public UUID createBook(CreateBookDto dto){
        var author = _authorRepository.findById(dto.authorId())
                .orElseThrow(() -> new BussinessException("Autor não encontrado"));
        var publisher = _publisherRepository.findById(dto.publisherId())
                .orElseThrow(() -> new BussinessException("Editora não encontrada"));

        Book book = new Book();
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setISBN(dto.isbn());
        book.setPublishedAt(dto.publishedAt());
        book.setTitle(dto.title());
        book.setPrice(dto.price());
        book.setStock(dto.stock());
        book.setGenre(dto.genre());
        book.setDescription(dto.description());
        book.setUrl(dto.url());
        book.setRatings(5.0);
        book.setAvailable(dto.stock() > 0);

        return _bookRepository.save(book).getBookId();
    }

    @Cacheable(value = "product", key = "#id")
    public Optional<BookResponseDto> getBookById(UUID id){

        return _bookRepository.findById(id)
                .map(this::toDto);

    }
    @Cacheable(value = "products")
    public List<BookResponseDto> getAllBooks(){
        System.out.println("Buscando todos os livros");

        return _bookRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public void updateBook(UUID bookId, UpdateBookDto dto){

        var entityBook = _bookRepository.findById(bookId)
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
            _bookRepository.save(entityBook);
        }

    public void deleteById(UUID bookId){
        if (bookId == null) {
            throw new BussinessException("O id não pode ser nulo");
        }

        if (!_bookRepository.existsById(bookId)) {
            throw new BussinessException("Livro não encontrado");
        }
        _bookRepository.deleteById(bookId);

    }

    private BookResponseDto toDto(Book book){
        return new BookResponseDto(
                book.getBookId(),
                book.getTitle(),
                book.getAuthor().getName(),
                book.getDescription(),
                book.getUrl(),
                book.getGenre(),
                book.getRatings(),
                book.getPublisher().getName(),
                book.getPublishedAt(),
                book.getPrice(),
                book.getStock(),
                book.getISBN(),
                book.isAvailable()
        );
    }
}

