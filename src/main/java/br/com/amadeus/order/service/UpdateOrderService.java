package br.com.amadeus.order.service;

import br.com.amadeus.order.exception.OrderNotFoundException;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateOrderService {

    private OrderRepository orderRepository;

    public Order save(Long id, Order order) {
        orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());
        order.setId(id);
        return orderRepository.save(order);
    }
}
