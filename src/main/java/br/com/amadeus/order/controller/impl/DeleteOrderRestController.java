package br.com.amadeus.order.controller.impl;

import br.com.amadeus.order.service.DeleteOrderService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DeleteOrderRestController implements OrderController {

    private DeleteOrderService deleteOrderService;

    @ApiOperation(value = "Delete existing order")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteOrderService.delete(id);
    }
}
