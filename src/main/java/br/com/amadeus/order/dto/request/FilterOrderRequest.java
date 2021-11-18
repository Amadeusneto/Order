package br.com.amadeus.order.dto.request;

import lombok.Data;

@Data
public class FilterOrderRequest {
    private String orderCode;
    private String registrationDate;
}
