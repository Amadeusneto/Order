package br.com.amadeus.order.service;

import br.com.amadeus.order.dto.response.OrderList;
import br.com.amadeus.order.exception.OrderControlNumberExistingException;
import br.com.amadeus.order.exception.OrderLimitedTenException;
import br.com.amadeus.order.exception.OrderWithoutProductsException;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateOrderService {

    private OrderRepository orderRepository;

    public void save(OrderList orderList) {
        validateOrderMoreThanTenProducts(orderList);
        for (Order order : orderList.getOrders()) {
            validateOrderWithoutProducts(order);
            validateControlNumberExistingOrder(order);
            calculateTotalValue(order);
            calculateDiscount(order);
        }
        orderRepository.saveAll(orderList.getOrders());
    }

    private void validateOrderWithoutProducts(Order order) throws OrderControlNumberExistingException {
        if (order.getProduct() == null)
            throw new OrderWithoutProductsException("O pedido deve ter pelo menos um produto");
    }

    private void validateControlNumberExistingOrder(Order order) {
        if (orderRepository.findByControlNumber(order.getControlNumber()).isPresent()) {
            throw new OrderControlNumberExistingException();
        }
    }

    private void calculateTotalValue(Order order) {
        Double total = order.getQuantity() * order.getProduct().getValue();
        order.setOrderTotal(total);
    }

    private void calculateDiscount(Order order) {
        calculateFivePercentDiscount(order);
        calculateTenPercentDiscount(order);
    }

    private void calculateFivePercentDiscount(Order order) {
        if (order.getQuantity() > 5 && order.getQuantity() < 10)
            order.setOrderTotal(order.getOrderTotal() * 0.95);
    }

    private void calculateTenPercentDiscount(Order order) {
        if (order.getQuantity() >= 10)
            order.setOrderTotal(order.getOrderTotal() * 0.90);
    }

    private void validateOrderMoreThanTenProducts(OrderList orderList) {
        if (orderList.getOrders() != null && orderList.getOrders().size() > 10) {
            throw new OrderLimitedTenException("O pedido está limitado a 10.");
        }
    }
}
