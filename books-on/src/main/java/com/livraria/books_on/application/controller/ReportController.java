package com.livraria.books_on.application.controller;


import com.livraria.books_on.application.service.ReportService;
import com.livraria.books_on.domain.dto.SalesDTOs.SalesReportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("v1/reports")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping("/daily")
    public ResponseEntity<SalesReportDto> getDailyReport(@RequestParam LocalDate date){
        return ResponseEntity.ok(reportService.getDailyReport(date));
    }
    @GetMapping("/monthly")
    public ResponseEntity<BigDecimal> getMonthlyRevenue(@RequestParam Integer year,
                                                        @RequestParam Integer month){
        return ResponseEntity.ok(reportService.getMonthlyRevenue(year, month));
    }
}
