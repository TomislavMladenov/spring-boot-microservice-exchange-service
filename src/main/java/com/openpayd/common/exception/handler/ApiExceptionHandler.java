package com.openpayd.common.exception.handler;

import com.openpayd.common.exception.CommonException;
import com.openpayd.common.exception.ErrorContainer;
import com.openpayd.common.exception.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public ResponseEntity<ErrorContainer> handleApiExceptions(CommonException e){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.getError());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorContainer handleApiExceptions(Exception e){
        return ErrorContainer
                .builder()
                .field("")
                .value("")
                .type(ErrorType.GENERAL_ERROR)
                .message(e.getMessage())
                .build();
    }
}
