package com.reporting.consumer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@RequiredArgsConstructor
public class TransactionReportRequest {
    // TODO: Format date as YYYY-MM-DD
    private Date fromDate;
    private Date toDate;
    private Integer merchant;
    private String acquirer;
}
