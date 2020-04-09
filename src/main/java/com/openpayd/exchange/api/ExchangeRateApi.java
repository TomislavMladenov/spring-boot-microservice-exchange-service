package com.openpayd.exchange.api;

import com.openpayd.exchange.service.ExchangeRateService;
import com.openpayd.exchange.service.ExchangeRateServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ExchangeRateApi {

    private ExchangeRateService exchangeRateService;

    public enum Url {;
        public static final String getExchangeRateFromTo = "/exchange/rate/from/{from}/to/{to}";
    }

    @GetMapping(value = Url.getExchangeRateFromTo)
    public ResponseEntity<String> getExchangeValueFromTo (@PathVariable String from, @PathVariable String to) {
        String exchangeRate = exchangeRateService.getExchangeRate(from, to);
        return ResponseEntity.ok(exchangeRate);
    }
}
