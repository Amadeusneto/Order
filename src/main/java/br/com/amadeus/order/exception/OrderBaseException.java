package br.com.amadeus.order.exception;

public abstract class OrderBaseException extends RuntimeException {
    public abstract OrderErrors error();
}
