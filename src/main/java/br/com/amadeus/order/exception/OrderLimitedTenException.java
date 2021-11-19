package br.com.amadeus.order.exception;

public class OrderLimitedTenException extends RuntimeException {

    private static final long serialVersionUID = 1869300553614629710L;

    public OrderLimitedTenException(String mensagem) {
        super(mensagem);
    }

    public OrderLimitedTenException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
