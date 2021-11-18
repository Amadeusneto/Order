package br.com.amadeus.order.service;

import br.com.amadeus.order.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FindOrderServiceTest extends BaseOrderServiceTest {
    @Autowired
    FindOrderService findOrderService;

    @BeforeEach
    public void setup() {
        Mockito.when(orderRepository.findById(13000L)).thenReturn(Optional.of(getOrder()));
    }

    @Test
    public void findMarketPlaceByIdTest() {
        Order order = findOrderService.findById(13000L);
        assertThat(order.getOrderCode()).isEqualTo(13000L);
    }
}
