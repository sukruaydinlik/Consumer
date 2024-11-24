package com.reporting.consumer.service;

import com.reporting.consumer.client.ApiClient;
import com.reporting.consumer.dto.ClientResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {

    private final ApiClient apiClient;

    public ClientResponse getById(String id) {
        return apiClient.getClient(Pair.of("transactionId", id));
    }

}