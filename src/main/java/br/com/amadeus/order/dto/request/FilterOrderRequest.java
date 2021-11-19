package br.com.amadeus.order.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilterOrderRequest {
    private Long clientCode;
    private LocalDate registrationDate;
}
