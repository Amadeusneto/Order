package br.com.amadeus.order.exception.message;

import br.com.amadeus.order.exception.OrderErrors;
import org.springframework.stereotype.Component;

@Component
public interface OrderBaseMessageSource {
    String getMessage(String resource, Object[] params);

    String getMessage(OrderErrors error, Object[] params);
}