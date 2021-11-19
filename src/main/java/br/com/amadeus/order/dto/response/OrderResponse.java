package br.com.amadeus.order.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class OrderResponse {
    private Long orderCode;
    private Long controlNumber;
    private Date registrationDate;
    private String name;
    private Double valor;
    private Integer quantity;
    private Long clientCode;
}
