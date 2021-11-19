package br.com.amadeus.order.exception;

public class ControlNumberExistingException extends RuntimeException {

    private static final long serialVersionUID = 1869300553614629710L;

    public ControlNumberExistingException(String mensagem) {
        super(mensagem);
    }

    public ControlNumberExistingException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
