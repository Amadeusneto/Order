package br.com.amadeus.order.service;

import br.com.amadeus.order.dto.response.OrderList;
import br.com.amadeus.order.exception.OrderExistingException;
import br.com.amadeus.order.exception.OrderLimitedTen;
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
        for(Order order : orderList.getOrders()) {
            validateOrderWithoutProducts(order);
            //validateExistingOrder(order);
            calculateTotalValue(order);
            calculateDiscount(order);
        }
        orderRepository.saveAll(orderList.getOrders());
    }

    private void validateOrderWithoutProducts(Order order) throws OrderExistingException {
        if (order.getProduct() == null)
            throw new OrderWithoutProductsException("O pedido deve ter pelo menos um produto");
    }

//    private void validateExistingOrder(Order order) {
//        if (order.getControlNumber() != null)
//            throw new OrderExistingException("O pedido já existe.");
//    }

    private void calculateTotalValue(Order order) {
        Double total = order.getQuantity() * order.getProduct().getValue();
        order.setOrderTotal(total);
    }

    private void calculateDiscount(Order order) {
        if (order.getQuantity() > 5 && order.getQuantity() < 10)
            order.setOrderTotal(order.getOrderTotal() * 0.95);
        if (order.getQuantity() >= 10)
            order.setOrderTotal(order.getOrderTotal() * 0.90);
    }

    private void validateOrderMoreThanTenProducts(OrderList orderList) {
        if (orderList.getOrders() !=null && orderList.getOrders().size() > 10) {
            throw new OrderLimitedTen("O pedido está limitado a 10.");
        }
    }
}
