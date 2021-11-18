package br.com.amadeus.order.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class OrderRequest {

    private Long controlNumber;
    private Date registrationDate;
    private Integer quantity;
    private Long clientCode;
    private ProductRequest product;
}
