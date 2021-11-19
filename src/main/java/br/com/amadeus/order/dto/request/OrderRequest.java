package br.com.amadeus.order.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long controlNumber;
    private LocalDate registrationDate;
    private Integer quantity;
    private Long clientCode;
    private ProductRequest product;
}
