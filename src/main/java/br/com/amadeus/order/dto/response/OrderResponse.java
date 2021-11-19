package br.com.amadeus.order.dto.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderResponse {
    private Long controlNumber;
    private LocalDate registrationDate;
    private Integer quantity;
    private Long clientCode;
    private Double orderTotal;
    private ProductResponse product;
}
