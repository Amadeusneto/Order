package br.com.amadeus.order.exception;

public class OrderExistingException extends RuntimeException{

    private static final long serialVersionUID = 1869300553614629710L;

    public OrderExistingException(String mensagem) {
        super(mensagem);
    }

    public OrderExistingException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
