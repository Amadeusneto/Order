package br.com.amadeus.order.service;

import br.com.amadeus.order.dto.request.OrderListRequest;
import br.com.amadeus.order.dto.request.OrderRequest;
import br.com.amadeus.order.dto.response.OrderList;
import br.com.amadeus.order.mappers.OrderMapper;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.repository.OrderRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseOrderServiceTest {
    @MockBean
    protected OrderRepository orderRepository;

    protected OrderListRequest orderListRequest;
    protected OrderList orderList;

    protected OrderListRequest getOrderRequest() {
        OrderListRequest orderListRequest1 = new OrderListRequest();
        for (OrderRequest orderRequest : orderListRequest.getOrders()) {
            orderRequest.setControlNumber(13L);
            orderRequest.setRegistrationDate(LocalDate.now());
            orderRequest.setQuantity(1);
            orderRequest.setClientCode(10L);
            orderRequest.getProduct().setName("PIZZA");
            orderRequest.getProduct().setValue(78.0);
            orderListRequest1.getOrders().add(orderRequest);
        }
        return orderListRequest1;
    }

    protected Order getOrder() {
        OrderListRequest orderListRequest = getOrderRequest();
        OrderList orderListX = OrderMapper.INSTANCE.orderListToEntity(orderListRequest);
        Order orders = OrderMapper.INSTANCE.orderToOrderListEntity(orderListX);
        orderListX.getOrders().get(0).setId(16000L);
        return orders;
    }
}
