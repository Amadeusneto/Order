package br.com.amadeus.order.exception;

public class OrderWithoutProductsException extends RuntimeException {

    private static final long serialVersionUID = 1869300553614629710L;

    public OrderWithoutProductsException(String mensagem) {
        super(mensagem);
    }

    public OrderWithoutProductsException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
