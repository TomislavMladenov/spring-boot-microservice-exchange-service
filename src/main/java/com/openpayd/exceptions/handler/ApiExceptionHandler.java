package com.openpayd.exceptions.handler;

import com.openpayd.exceptions.CommonException;
import com.openpayd.exceptions.ErrorContainer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public abstract class ApiExceptionHandler {

    @ExceptionHandler(value = {CommonException.class})
    public ResponseEntity<Object> handleApiExceptions(CommonException e){
        ErrorContainer errorContainer = new ErrorContainer(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorContainer, HttpStatus.BAD_REQUEST);
    }
}
