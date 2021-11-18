package br.com.amadeus.order.service;

import br.com.amadeus.order.exception.OrderNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DeleteOrderServiceTest extends BaseOrderServiceTest {
    @Autowired
    DeleteOrderService deleteOrderService;

    @BeforeEach
    public void setup() {
        Mockito.when(orderRepository.findById(13000L)).thenReturn(Optional.of(getOrder()));
        Mockito.doNothing().when(orderRepository).delete(any());
    }

    @Test
    public void deleteOrderTest() {
        deleteOrderService.delete(13000L);
        verify(orderRepository, times(1)).delete(any());
    }

    @Test
    public void deleteOrderNotFoundExceptionTest() {
        assertThrows(OrderNotFoundException.class, () -> deleteOrderService.delete(11000L));
    }
}
