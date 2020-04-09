package com.openpayd.exceptions;

import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;


public class ErrorContainer {

    private  String message;
    @NotNull
    private  HttpStatus httpStatus;
    private  ZonedDateTime timestamp;

    public ErrorContainer() {
    }

    public ErrorContainer(String message, @NotNull HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorType(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
