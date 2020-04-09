package com.openpayd.conversion.dao;

import com.openpayd.conversion.model.Conversion;

public interface ConversionDao {

    Conversion getTransaction(Float sourceAmount, String sourceCurrency, String targetCurrency);
}
