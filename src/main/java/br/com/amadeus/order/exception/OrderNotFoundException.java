package br.com.amadeus.order.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OrderNotFoundException extends IllegalArgumentException {

    public OrderNotFoundException(String message) {
        super(message);
    }
}
