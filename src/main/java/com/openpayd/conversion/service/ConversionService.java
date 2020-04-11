package com.openpayd.conversion.service;

import com.openpayd.conversion.model.Conversion;

public interface ConversionService {

    Conversion makeTransaction(Float sourceAmount, String sourceCurrency, String targetCurrency);
}
