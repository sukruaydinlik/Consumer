package com.reporting.consumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TransactionListResponse {
    @JsonProperty("per_page")
    private String perPage;
    @JsonProperty("current_page")
    private String currentPage;
    @JsonProperty("next_page_url")
    private String nextPageUrl;
    @JsonProperty("prev_page_url")
    private String prevPageUrl;
    private Integer from;
    private Integer to;
    private Object[] data; // Can create a class for this

}
