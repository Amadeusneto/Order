package br.com.amadeus.order.exception.message;

import br.com.amadeus.order.exception.OrderErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMessageSource implements OrderBaseMessageSource {
    private final MessageSource messageSource;

    public String getMessage(OrderErrors error, Object[] params) {
        return getMessage(error.getMessageRes(), params);
    }

    public String getMessage(String resource, Object[] params) {
        return messageSource.getMessage(resource, params, LocaleContextHolder.getLocale());
    }
}