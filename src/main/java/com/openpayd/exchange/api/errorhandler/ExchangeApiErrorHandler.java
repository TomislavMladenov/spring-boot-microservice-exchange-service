package com.openpayd.exchange.api.errorhandler;

import com.openpayd.common.exception.ErrorContainer;
import com.openpayd.exchange.exception.QuoteNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExchangeApiErrorHandler {

    @ExceptionHandler(value = QuoteNotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorContainer handleNoQuotes(QuoteNotFound e){
        return e.getError();
    }
}
