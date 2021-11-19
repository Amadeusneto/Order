package br.com.amadeus.order.dto.response;

import lombok.Data;

@Data
public class OrderResponse {
    private Long controlNumber;
    private String registrationDate;
    private Integer quantity;
    private Long clientCode;
    private Double orderTotal;
    private ProductResponse product;
}
