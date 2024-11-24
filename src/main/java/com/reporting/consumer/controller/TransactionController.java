package com.reporting.consumer.controller;

import com.reporting.consumer.dto.TransactionListRequest;
import com.reporting.consumer.dto.TransactionListResponse;
import com.reporting.consumer.dto.TransactionReportRequest;
import com.reporting.consumer.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TransactionController.PATH)
@AllArgsConstructor
public class TransactionController {
    public static final String PATH = "/v3/transaction";

    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public Object getTransaction(@PathVariable String id) {
        return transactionService.getById(id);
    }

    @PostMapping("/list")
    public TransactionListResponse getTransactions(@RequestBody TransactionListRequest request) {
        return transactionService.getByFilter(request);
    }

    @PostMapping("/report")
    public Object getTransactionReport(@RequestBody TransactionReportRequest request) {
        return transactionService.getReport(request);
    }
}
