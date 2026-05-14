package com.livraria.books_on.application.service;

import com.livraria.books_on.domain.dto.SalesDTOs.SalesReportDto;
import com.livraria.books_on.domain.dto.SalesDTOs.TopSellingBookDto;
import com.livraria.books_on.domain.repository.SaleItemRepository;
import com.livraria.books_on.domain.repository.SalesRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {
    private final SalesRepository salesRepository;
    private final SaleItemRepository saleItemRepository;

    public ReportService(SalesRepository salesRepository, SaleItemRepository saleItemRepository) {
        this.salesRepository = salesRepository;
        this.saleItemRepository = saleItemRepository;
    }
    public SalesReportDto getDailyReport(LocalDate date){
        BigDecimal revenue = salesRepository.getDailyRevenue(date);

        Long totalSales = salesRepository.getDailySales(date);

        List<TopSellingBookDto> topBooks = saleItemRepository.getTopSellingBooks();

        return new SalesReportDto(
                revenue,
                totalSales,
                topBooks
        );
    }
    public BigDecimal getMonthlyRevenue(Integer year, Integer month){
        return salesRepository.getMouthlyRevenue(year, month);
    }
}
