package com.reporting.consumer.service;

import com.reporting.consumer.client.ApiClient;
import com.reporting.consumer.dto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {

    @Mock
    private ApiClient apiClient;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    // TODO: Test cases may need to be updated based on the actual use cases and changes made in the service
    @Test
    public void testGetById() {
        String transactionId = "123";
        Object mockResponse = new Object(); // Replace with actual response type

        when(apiClient.getTransaction(Pair.of("transactionId", transactionId))).thenReturn(mockResponse);

        Object response = transactionService.getById(transactionId);

        assertEquals(mockResponse, response);
    }

    @Test
    public void testGetByFilter() {
        TransactionListRequest request = new TransactionListRequest();
        request.setStatus(TransactionStatus.APPROVED);
        request.setOperation(TransactionListRequest.Operation.DIRECT);

        TransactionListResponse mockResponse = new TransactionListResponse();
        mockResponse.setTo(4);
        mockResponse.setFrom(5);

        when(apiClient.getTransactions(request)).thenReturn(mockResponse);

        TransactionListResponse response = transactionService.getByFilter(request);

        assertEquals(mockResponse, response);
    }

    @Test
    public void testGetReport() {
        TransactionReportRequest request = new TransactionReportRequest();
        TransactionReportResponse mockResponse = new TransactionReportResponse();

        when(apiClient.getTransactionReport(request)).thenReturn(mockResponse);

        TransactionReportResponse response = transactionService.getReport(request);

        assertEquals(mockResponse, response);
    }
}