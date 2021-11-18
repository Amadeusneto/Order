package br.com.amadeus.order.mappers;

import br.com.amadeus.order.dto.request.OrderListRequest;
import br.com.amadeus.order.dto.request.OrderRequest;
import br.com.amadeus.order.dto.response.OrderList;
import br.com.amadeus.order.dto.response.OrderResponse;
import br.com.amadeus.order.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order createOrderRequestToOrderEntity(OrderRequest orderRequest);
    OrderResponse orderEntityToOrderResponse(Order order);
    OrderList orderListToEntity(OrderListRequest orderListRequest);
    Order orderToOrderListEntity(OrderList orderList);
}
