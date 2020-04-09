package com.openpayd.exchange.service;
import com.openpayd.exceptions.CommonException;
import com.openpayd.exchange.dao.ExchangeRateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    private final ExchangeRateDao exchangeRateDao;

    @Autowired
    public ExchangeRateService(ExchangeRateDao exchangeRateDao){
        this.exchangeRateDao = exchangeRateDao;
    }

    public String getExchangeRate(String from, String to){
        return exchangeRateDao.getExchangeRate(from, to).orElseThrow(() -> new CommonException("Currency pair not found! Please try with other available currency."));
    }
}
