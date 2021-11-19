package br.com.amadeus.order.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderResponse {
    private Long controlNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate registrationDate;
    private Integer quantity;
    private Long clientCode;
    private Double orderTotal;
    private ProductResponse product;
}
