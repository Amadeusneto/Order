package br.com.amadeus.order.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum OrderErrors {
    SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "error.server"),
    BAD_REQUEST_ERROR(HttpStatus.BAD_REQUEST, 400, "error.badRequest"),
    UNAUTHORIZED_ERROR(HttpStatus.UNAUTHORIZED, 401, "error.unauthorized"),
    FORBIDDEN_ERROR(HttpStatus.FORBIDDEN, 403, "error.forbidden"),
    NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, 404, "error.notFound"),
    METHOD_NOT_ALLOWED_ERROR(HttpStatus.METHOD_NOT_ALLOWED, 405, "error.methodNotAllowed"),
    BINDING_VALIDATION_ERROR(HttpStatus.UNPROCESSABLE_ENTITY, 905, "error.bindValidation"),

    // Application Errors
    ORDER_NOT_FOUND(HttpStatus.BAD_REQUEST, 400, "error.orderNotFound"),
    ;

    private final HttpStatus httpStatus;
    private final int code;
    private final String messageRes;
    private final Map<String, Object> details = new HashMap<>();
}
