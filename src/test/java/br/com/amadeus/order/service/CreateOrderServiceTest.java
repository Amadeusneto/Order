package br.com.amadeus.order.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateOrderServiceTest extends BaseOrderServiceTest {
    @Autowired
    CreateOrderService createOrderService;

    @BeforeEach
    public void setup() {
        Mockito.when(orderRepository.save(Mockito.any())).thenReturn(getOrder());
    }

    @Test
    public void saveOrderTest() {
       // Order orderSaved = createOrderService.save(OrderMapper.INSTANCE.orderListToEntity(orderListRequest));
        //OrderListRequest orderSaved = createOrderService.save(orderListRequest);
       // assertThat(orderSaved.getOrders().get(0).getId()).isEqualTo(13000L);
    }
}
