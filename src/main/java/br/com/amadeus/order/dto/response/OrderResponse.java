package br.com.amadeus.order.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class OrderResponse {
    private Long controlNumber;
    private Date registrationDate;
    private Integer quantity;
    private Long clientCode;
    private ProductResponse product;
}
