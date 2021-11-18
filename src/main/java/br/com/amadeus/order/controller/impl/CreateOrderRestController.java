package br.com.amadeus.order.controller.impl;

import br.com.amadeus.order.dto.request.OrderRequest;
import br.com.amadeus.order.dto.response.OrderResponse;
import br.com.amadeus.order.mappers.OrderMapper;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.service.CreateOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@AllArgsConstructor
public class CreateOrderRestController implements OrderController {
    private CreateOrderService createOrderService;

    @ApiOperation(value = "Save a new order")
    @PostMapping
    public ResponseEntity<?> saveCommunication(@RequestBody @Valid OrderRequest orderRequest) {
        Order order = createOrderService.save(OrderMapper.INSTANCE.createOrderRequestToOrderEntity(orderRequest));
        OrderResponse orderResponse = OrderMapper.INSTANCE.orderEntityToOrderResponse(order);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(orderResponse.getOrderCode()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
