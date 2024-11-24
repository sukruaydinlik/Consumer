package com.reporting.consumer.controller;

import com.reporting.consumer.dto.ClientResponse;
import com.reporting.consumer.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClientController.PATH)
@AllArgsConstructor
public class ClientController {
    public static final String PATH = "/v3/client";

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ClientResponse getClient(@PathVariable String id) {
        return clientService.getById(id);
    }

}
