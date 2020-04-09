package com.openpayd.common.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonException extends RuntimeException  {

    private ErrorContainer error;

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, ErrorType errorType) {
        super(message);
        this.error = new ErrorContainer();
        this.error.setMessage(message);
        this.error.setType(errorType);
    }



}
