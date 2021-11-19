package br.com.amadeus.order.dto.response;

import br.com.amadeus.order.model.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderList {
    private List<Order> orders;
}
