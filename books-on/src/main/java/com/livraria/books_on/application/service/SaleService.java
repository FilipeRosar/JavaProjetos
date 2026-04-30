package com.livraria.books_on.application.service;


import com.livraria.books_on.application.dto.SaleItemRequestDto;
import com.livraria.books_on.application.dto.SalesDTOs.CreateSaleRequestDto;
import com.livraria.books_on.application.dto.SalesDTOs.SaleItemResponseDto;
import com.livraria.books_on.application.dto.SalesDTOs.SaleResponseDto;
import com.livraria.books_on.domain.entity.Books;
import com.livraria.books_on.domain.entity.Sale;
import com.livraria.books_on.domain.entity.SaleItem;
import com.livraria.books_on.domain.entity.User;
import com.livraria.books_on.domain.repository.BookRepository;
import com.livraria.books_on.domain.repository.SalesRepository;
import com.livraria.books_on.domain.repository.UserRepository;
import com.livraria.books_on.infrastructure.exception.BussinessException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class SaleService {
    private final SalesRepository _salesRepository;
    private final BookRepository _bookRepository;
    private final UserRepository _userRepository;

    public SaleService(SalesRepository salesRepository, BookRepository BookRepository, UserRepository userRepository) {
        _salesRepository = salesRepository;
        _bookRepository = BookRepository;
        _userRepository = userRepository;
    }
    @Transactional
    public SaleResponseDto createSale(CreateSaleRequestDto dto){
        User user = _userRepository.findById(dto.userId())
                .orElseThrow(() -> new BussinessException("Usuário não encontrado"));

        Sale sale = new Sale();
        sale.setUser(user);
        sale.setData(new Date());
        List<SaleItem> items = new ArrayList<>();
        BigDecimal total =  BigDecimal.ZERO;

        for (SaleItemRequestDto itemDto : dto.items()){
            Books book = _bookRepository.findById(itemDto.bookId())
                    .orElseThrow(() -> new BussinessException("Livro não encontrado"));

            if (book.getStock() < itemDto.quantity()){
                throw new BussinessException("Sem estoque: " + book.getTitle());
            }
            book.setStock(book.getStock() - itemDto.quantity());
            book.setAvailable(book.getStock() > 0);

            SaleItem saleItem = new SaleItem();
            saleItem.setSale(sale);
            saleItem.setBook(book);
            saleItem.setQuantity(itemDto.quantity());
            saleItem.setPrice(book.getPrice());

            BigDecimal itemTotal = book.getPrice()
                    .multiply(BigDecimal.valueOf(itemDto.quantity()));

            total = total.add(itemTotal);

            items.add(saleItem);
        }
        sale.setItems(items);
        sale.setTotal(total);
        _salesRepository.save(sale);

        List<SaleItemResponseDto> responseItems = items.stream()
                .map(i -> new SaleItemResponseDto(
                        i.getBook().getBookId(),
                        i.getBook().getTitle(),
                        i.getQuantity(),
                        i.getPrice()
                )).toList();
        return new SaleResponseDto(
                sale.getId(),
                total,
                responseItems
        );
    }
    public Optional<Sale> getSaleById(UUID saleId){
        return _salesRepository.findById(saleId);
    }
    @Transactional
    public void returnSale(UUID saleId){
        Sale sale = _salesRepository.findById(saleId)
                .orElseThrow(() -> new BussinessException("Venda não encontrada"));

        for (SaleItem item : sale.getItems()) {
            Books books = item.getBook();
            books.setStock(books.getStock() + item.getQuantity());
            books.setAvailable(true);
            _bookRepository.save(books);
        }
    }
}
