package br.com.amadeus.order.exception;

public class OrderLimitedTen extends RuntimeException{

    private static final long serialVersionUID = 1869300553614629710L;

    public OrderLimitedTen(String mensagem) {
        super(mensagem);
    }

    public OrderLimitedTen(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
