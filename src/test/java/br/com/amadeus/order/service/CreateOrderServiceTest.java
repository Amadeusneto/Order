package br.com.amadeus.order.service;

import br.com.amadeus.order.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateOrderServiceTest extends BaseOrderServiceTest {
    @Autowired
    CreateOrderService createOrderService;

    @BeforeEach
    public void setup() {
        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(getOrder());
    }

    @Test
    public void saveOrderTest() {
        Order orderSaved = createOrderService.save(order);
        assertThat(orderSaved.getOrderCode()).isEqualTo(13000L);
    }
}
