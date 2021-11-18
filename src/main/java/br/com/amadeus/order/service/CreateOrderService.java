package br.com.amadeus.order.service;

import br.com.amadeus.order.exception.OrderExistingException;
import br.com.amadeus.order.exception.OrderLimitedTen;
import br.com.amadeus.order.exception.OrderWithoutProductsException;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class CreateOrderService {

    private OrderRepository orderRepository;

    public Order save(Order order) {
        validateOrderWithoutProducts(order);
        validateExistingOrder(order);
        validateRegistrationDate(order);
        calculateValueTotal(order);
        validateOrderMoreThanTenProducts(order);
        return orderRepository.save(order);
    }

    private void validateOrderWithoutProducts(Order order) throws OrderExistingException {
        if (order.getOrderCode() == null)
            throw new OrderWithoutProductsException("O pedido deve ter pelo menos um produto");
    }

    private void validateExistingOrder(Order order) {
        if (order.getControlNumber() != null)
            throw new OrderExistingException("O pedido já existe.");
    }

    private void validateRegistrationDate(Order order) {
        if (order.getRegistrationDate() == null)
            order.setRegistrationDate(java.sql.Date.valueOf(LocalDate.now()));
    }

    private void calculateValueTotal(Order order) {
        Double productTotal = 0.0;
        productTotal += (getProductTotal(order));
        order.setOrderTotal(productTotal);
    }

    private Double getProductTotal(Order order) {
        Double total = 0.0;
        total = validateQuantityEqualZero(total, order);
        if (validateFivePercentApplication(total, order)) return total - (total * 10) / 100;
        if (validateTenPercentApplication(total, order)) return total - (total * 5) / 100;
        return total;
    }

    private boolean validateTenPercentApplication(Double total, Order order) {
        if (order.getQuantity() > 5 && order.getQuantity() < 10) {
            return true;
        }
        return false;
    }

    private boolean validateFivePercentApplication(Double total, Order order) {
        if (order.getQuantity() >= 10) {
            return true;
        }
        return false;
    }

    private Double validateQuantityEqualZero(Double total, Order order) {
        if (order.getQuantity() == 0) {
            order.setQuantity(1);
            total = order.getQuantity() * order.getValor();
        }
        return total;
    }

    private void validateOrderMoreThanTenProducts(Order order) {
        if (order.getOrderProduct().size() > 10) {
            throw new OrderLimitedTen("O pedido está limitado a 10.");
        }
    }
}
