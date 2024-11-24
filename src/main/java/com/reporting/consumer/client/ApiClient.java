package com.reporting.consumer.client;


import com.reporting.consumer.dto.*;
import com.reporting.consumer.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "apiClient", url = "${feign.client.url}", configuration = FeignConfig.class)
public interface ApiClient {

    @GetMapping("/transaction/report")
    TransactionReportResponse getTransactionReport(@RequestBody TransactionReportRequest request);

    @PostMapping("/transaction/list")
    TransactionListResponse getTransactions(@RequestBody TransactionListRequest request);

    // TODO: Couldn't test this without proper transactionId, so Object is a placeholder
    @PostMapping("/transaction")
    Object getTransaction(Pair<String, String> transactionId);

    // TODO: This doesn't make sense (transactionId) but I'm keeping it as is
    @GetMapping("/client")
    ClientResponse getClient(Pair<String, String> transactionId);
}
