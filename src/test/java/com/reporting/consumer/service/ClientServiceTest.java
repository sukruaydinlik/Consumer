package com.reporting.consumer.service;

import com.reporting.consumer.client.ApiClient;
import com.reporting.consumer.dto.ClientResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Pair;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class ClientServiceTest {

    @Mock
    private ApiClient apiClient;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetById() {
        Integer clientId = 123;
        ClientResponse mockResponse = new ClientResponse();
        ClientResponse.CustomerInfo customerInfo = new ClientResponse.CustomerInfo();
        customerInfo.setEmail("customer@example.com");
        mockResponse.setCustomerInfo(customerInfo);

        when(apiClient.getClient(Pair.of("transactionId", String.valueOf(clientId)))).thenReturn(mockResponse);

        ClientResponse response = clientService.getById(String.valueOf(clientId));

        assertEquals("customer@example.com", response.getCustomerInfo().getEmail());
    }

}