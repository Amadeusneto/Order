package br.com.amadeus.order.service;

import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateOrderServiceTest extends BaseOrderServiceTest {
    @Autowired
    UpdateOrderService updateOrderService;

    Order orderUpdate;
    Product productUpdate;

    @BeforeEach
    public void setup() {
        productUpdate = getOrder().getProduct();
        orderUpdate.getProduct().setName("BOLO");
        Mockito.when(orderRepository.findById(13000L)).thenReturn(Optional.of(getOrder()));
        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(productUpdate);
    }

    @Test
    public void updateOrderByIdTest() {
        Order order = updateOrderService.save(13000L, orderUpdate);
        assertThat(order.getId()).isEqualTo(13000L);
    }
}
