package br.com.amadeus.order.exception;

import br.com.amadeus.order.dto.response.OrderBaseResponse;
import br.com.amadeus.order.exception.message.OrderBaseMessageSource;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class OrderGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final OrderBaseMessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        if (OrderBaseException.class.isAssignableFrom(e.getClass())) {
            return handleException(((OrderBaseException) e).error(), e.getMessage(), e);
        }

        return handleException(OrderErrors.SERVER_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundCommunicationException(OrderNotFoundException e, WebRequest request) {
        return handleException(OrderErrors.ORDER_NOT_FOUND, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleException(OrderErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                                         HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleException(OrderErrors.METHOD_NOT_ALLOWED_ERROR, e.getMessage(), e);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException e, HttpHeaders headers,
                                                                   HttpStatus status, WebRequest request) {
        return handleException(OrderErrors.NOT_FOUND_ERROR, e.getMessage(), e);
    }

    private ResponseEntity<Object> handleException(OrderErrors error, String message, Exception e) {
        return handleException(error, new Object[]{message}, e);
    }

    private ResponseEntity<Object> handleException(OrderErrors error, Object[] params, Exception e) {
        String message = messageSource.getMessage(error, params);
        logger.error(message, e);

        return ResponseEntity.status(error.getHttpStatus())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(OrderBaseResponse.notOk(error.getCode(), message, error.getDetails()));
    }

    private ResponseEntity<Object> handleException(OrderErrors error, List<OrderBaseResponse.Error> errors, Exception e) {
        logger.error("Error", e);

        return ResponseEntity.status(error.getHttpStatus())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(OrderBaseResponse.notOk(errors));
    }

    @ExceptionHandler(OrderControlNumberExistingException.class)
    public ResponseEntity<Object> handleControlNumberExistingException(OrderControlNumberExistingException e, WebRequest request) {
        return handleException(OrderErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Object> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e, WebRequest request) {
        return handleException(OrderErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException e, WebRequest request) {
        return handleException(OrderErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException e, WebRequest request) {
        return handleException(OrderErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(OrderLimitedTenException.class)
    public ResponseEntity<Object>  handleorderLimitedTenException(OrderLimitedTenException e, WebRequest request) {
        return handleException(OrderErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

    @ExceptionHandler(OrderWithoutProductsException.class)
    public ResponseEntity<Object>  handleorderWithoutProductsException(OrderWithoutProductsException e, WebRequest request) {
        return handleException(OrderErrors.BAD_REQUEST_ERROR, e.getMessage(), e);
    }

}
