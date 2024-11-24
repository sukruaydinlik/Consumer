package com.reporting.consumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientResponse {
    private CustomerInfo customerInfo;

    @Getter
    @Setter
    @RequiredArgsConstructor
    public static class CustomerInfo {
        private Integer id;
        @JsonProperty("created_at")
        private String createdAt;
        @JsonProperty("updated_at")
        private String updatedAt;
        @JsonProperty("deleted_at")
        private String deletedAt;
        private String number;
        private String expiryMonth;
        private String expiryYear;
        private String startMonth;
        private String startYear;
        private String issueNumber;
        private String email;
        private String birthday;
        private String gender;
        private String billingTitle;
        private String billingFirstName;
        private String billingLastName;
        private String billingCompany;
        private String billingAddress1;
        private String billingAddress2;
        private String billingCity;
        private String billingPostcode;
        private String billingState;
        private String billingCountry;
        private String billingPhone;
        private String billingFax;
        private String shippingTitle;
        private String shippingFirstName;
        private String shippingLastName;
        private String shippingCompany;
        private String shippingAddress1;
        private String shippingAddress2;
        private String shippingCity;
        private String shippingPostcode;
        private String shippingState;
        private String shippingCountry;
        private String shippingPhone;
        private String shippingFax;


    }
}
