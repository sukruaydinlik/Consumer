package com.reporting.consumer.client;


import com.reporting.consumer.config.AuthRequest;
import com.reporting.consumer.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transactionClient", url = "${feign.client.url}", configuration = FeignConfig.class)
public interface Client {

    @PostMapping("/authenticate")
    String authenticate(@RequestBody AuthRequest authRequest);

    @GetMapping("/transactions/report")
    String getTransactionReport();

    @GetMapping("/transactions/list")
    String getTransactions();

    @GetMapping("/transactions/get")
    String getTransaction();

    @GetMapping("/client")
    String getClient();
}
