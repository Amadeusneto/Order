package br.com.amadeus.order.service;

import br.com.amadeus.order.dto.request.OrderRequest;
import br.com.amadeus.order.mappers.OrderMapper;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.repository.OrderRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseOrderServiceTest {
    @MockBean
    protected OrderRepository orderRepository;

    protected OrderRequest orderRequest;
    protected Order order;

    protected OrderRequest getOrderRequest() {
        return OrderRequest.builder()
                .orderCode(5L)
                .controlNumber(7L)
                .registrationDate(new Date())
                .name("PIZZA")
                .valor(78.0D)
                .quantity(1)
                .clientCode(10L)
                .build();
    }

    protected Order getOrder() {
        OrderRequest orderRequest = getOrderRequest();
        Order orderX = OrderMapper.INSTANCE.createOrderRequestToOrderEntity(orderRequest);
        orderX.setOrderCode(16000L);
        return orderX;
    }
}
