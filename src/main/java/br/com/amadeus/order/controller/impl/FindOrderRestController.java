package br.com.amadeus.order.controller.impl;

import br.com.amadeus.order.dto.request.FilterOrderRequest;
import br.com.amadeus.order.dto.response.OrderResponse;
import br.com.amadeus.order.mappers.OrderMapper;
import br.com.amadeus.order.model.Order;
import br.com.amadeus.order.service.FindOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FindOrderRestController implements OrderController {

    private FindOrderService findOrderService;

    @ApiOperation(value = "Find Order by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Order order = findOrderService.findById(id);
        OrderResponse orderResponse = OrderMapper.INSTANCE.orderEntityToOrderResponse(order);
        return ResponseEntity.ok().body(orderResponse);
    }

    @ApiOperation(value = "Find order using filters and pagination")
    @GetMapping
    public Page<?> findByFilter(FilterOrderRequest filterMarketplaceRequest, Pageable pageable) {
        return findOrderService.findByFiltersAndPagination(filterMarketplaceRequest, pageable);
    }
}
