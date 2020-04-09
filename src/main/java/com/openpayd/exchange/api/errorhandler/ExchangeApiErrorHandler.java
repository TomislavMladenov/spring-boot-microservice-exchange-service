package com.openpayd.exchange.api.errorhandler;

import com.openpayd.exchange.exception.QuoteNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExchangeApiErrorHandler {

    @ExceptionHandler(value = QuoteNotFound.class)
    public ResponseEntity<?> handleNoQuotes(QuoteNotFound e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getError());
    }
}
