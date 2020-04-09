package com.openpayd.exchange.exception;

import com.openpayd.common.exception.CommonException;
import com.openpayd.common.exception.ErrorContainer;

public class QuoteNotFound extends CommonException {

    public QuoteNotFound(String message, String quoteKey) {
        super(message);
        ErrorContainer error = new ErrorContainer();
        error.setField("quote");
        error.setValue(quoteKey);
        error.setMessage(message);
        setError(error);
    }
}
