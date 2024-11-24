package com.reporting.consumer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionListRequest {

    public enum Operation {
        DIRECT("DIRECT"),
        REFUND("REFUND"),
        THREE_D("3D"),
        THREE_D_AUTH("3DAUTH"),
        AUTH("AUTH"),
        STORED("STORED");

        Operation(String direct) {

        }
    }

    private Date fromDate;
    private Date toDate;
    private TransactionStatus status;
    private Operation operation;
    private String merchantId;
    private String acquirerId;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private Integer page;
}
