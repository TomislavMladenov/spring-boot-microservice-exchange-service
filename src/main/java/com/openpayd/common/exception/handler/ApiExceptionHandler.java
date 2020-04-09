package com.openpayd.common.exception.handler;

import com.openpayd.common.exception.CommonException;
import com.openpayd.common.exception.ErrorContainer;
import com.openpayd.exchange.exception.QuoteNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public abstract class ApiExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public ResponseEntity<Object> handleApiExceptions(CommonException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getError());
    }

}
