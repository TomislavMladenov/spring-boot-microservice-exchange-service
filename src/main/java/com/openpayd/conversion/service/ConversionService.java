package com.openpayd.conversion.service;

import com.openpayd.conversion.dao.ConversionDao;
import com.openpayd.conversion.model.Conversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConversionService {

    private final ConversionDao conversionDao;

    @Autowired
    public ConversionService(ConversionDao conversionDao){
        this.conversionDao = conversionDao;
    }

    public Conversion getConversion(Float sourceAmount, String sourceCurrency, String targetCurrency){
        return conversionDao.getTransaction(sourceAmount, sourceCurrency, targetCurrency);
    }
}
