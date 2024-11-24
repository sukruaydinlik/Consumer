package com.reporting.consumer.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TransactionReportResponse {
    private TransactionStatus status;
    private TransactionReportItem[] response;

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class TransactionReportItem {
        private Integer count;
        private Integer total;
        private String currency;
    }
}
