package br.com.amadeus.order.service;

import br.com.amadeus.order.dto.request.FilterOrderRequest;
import br.com.amadeus.order.exception.OrderNotFoundException;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.repository.OrderRepository;
import br.com.amadeus.order.repository.OrderSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindOrderService {

    private OrderRepository orderRepository;
    private OrderSpecification orderSpecification;

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException());
    }

    public Page<Order> findByFiltersAndPagination(FilterOrderRequest filterOrderRequest, Pageable pageable) {
        return orderRepository.findAll(orderSpecification.getOrderByFilter(filterOrderRequest), pageable);
    }


}
