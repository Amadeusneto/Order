package br.com.amadeus.order.controller.impl;

import br.com.amadeus.order.dto.request.OrderRequest;
import br.com.amadeus.order.dto.response.OrderResponse;
import br.com.amadeus.order.mappers.OrderMapper;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.service.UpdateOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UpdateOrderRestController implements OrderController {
    private UpdateOrderService updateOrderService;

    @ApiOperation(value = "Update a existing orders")
    @PutMapping("/{id}")
    public ResponseEntity<?> saveCommunication(@PathVariable Long id, @RequestBody @Valid OrderRequest orderRequest) {
        Order order = updateOrderService.save(id, OrderMapper.INSTANCE.createOrderRequestToOrderEntity(orderRequest));
        OrderResponse orderResponse = OrderMapper.INSTANCE.orderEntityToOrderResponse(order);
        return ResponseEntity.ok().body(orderResponse);
    }
}
