package com.livraria.books_on.application.controller;

import com.livraria.books_on.domain.dto.SalesDTOs.CreateSaleRequestDto;
import com.livraria.books_on.application.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<?> addSale(@RequestBody CreateSaleRequestDto dto){
        return ResponseEntity.ok(saleService.createSale(dto));
    }
}
