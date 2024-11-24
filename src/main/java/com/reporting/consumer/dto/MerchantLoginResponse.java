package com.reporting.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MerchantLoginResponse {
    private String token;
    private String status;
}