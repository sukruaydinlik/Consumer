package com.reporting.consumer.service;

import com.reporting.consumer.client.ApiClient;
import com.reporting.consumer.dto.TransactionListRequest;
import com.reporting.consumer.dto.TransactionListResponse;
import com.reporting.consumer.dto.TransactionReportRequest;
import com.reporting.consumer.dto.TransactionReportResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionService {

    private final ApiClient apiClient;

    public Object getById(String id) {
        try {
            return apiClient.getTransaction(Pair.of("transactionId", id));
        } catch (Exception e) {
            // handle exception here according to business logic
            return new Object();
        }
    }

    public TransactionListResponse getByFilter(TransactionListRequest request) {
        try {
            return apiClient.getTransactions(request);
        } catch (Exception e) {
            // handle exception here according to business logic
            return new TransactionListResponse();
        }
    }

    public TransactionReportResponse getReport(TransactionReportRequest request) {
        try {
            return apiClient.getTransactionReport(request);
        } catch (Exception e) {
            return new TransactionReportResponse();
        }
    }

}