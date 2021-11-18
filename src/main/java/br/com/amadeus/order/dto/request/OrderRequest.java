package br.com.amadeus.order.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long orderCode;
    private Long controlNumber;
    private Date registrationDate;
    private String name;
    private Double valor;
    private Integer quantity;
    private Long clientCode;
}
