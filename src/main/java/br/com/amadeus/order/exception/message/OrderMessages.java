package br.com.amadeus.order.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderMessages {
    TEMP("message.temp");

    @Getter
    private final String value;
}