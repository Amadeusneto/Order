package br.com.amadeus.order.service;

import br.com.amadeus.order.exception.OrderNotFoundException;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteOrderService {

    private OrderRepository orderRepository;

    public void delete(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());
        orderRepository.delete(order);
    }
}
