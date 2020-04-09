package com.openpayd.exchange.api;

import com.openpayd.exceptions.CommonException;
import com.openpayd.exceptions.handler.ApiExceptionHandler;
import com.openpayd.exchange.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/exchangeRate")
public class ExchangeRateApi {

    private ExchangeRateService exchangeRateService;

    public enum Url {;
        public static final String getExchangeRateFromTo = "/from/{from}/to/{to}";
    }


    @Autowired
    public ExchangeRateApi(ExchangeRateService exchangeRateService){
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping(value = Url.getExchangeRateFromTo)
    private ResponseEntity<String> getExchangeValueFromTo (@PathVariable String from, @PathVariable String to) {
        return ResponseEntity.ok(exchangeRateService.getExchangeRate(from, to));
    }
}
