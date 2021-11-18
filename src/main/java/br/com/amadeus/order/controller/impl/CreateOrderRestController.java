package br.com.amadeus.order.controller.impl;

import br.com.amadeus.order.dto.request.OrderListRequest;
import br.com.amadeus.order.mappers.OrderMapper;
import br.com.amadeus.order.service.CreateOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CreateOrderRestController implements OrderController {
    private CreateOrderService createOrderService;

    @ApiOperation(value = "Save a new order")
    @PostMapping
    public ResponseEntity<Void> saveCommunication(@RequestBody OrderListRequest orderListRequest) {
        createOrderService.save(OrderMapper.INSTANCE.orderListToEntity(orderListRequest));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
