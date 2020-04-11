package com.openpayd.conversion.config;

import com.openpayd.conversion.dao.ConversionRepository;
import com.openpayd.conversion.service.ConversionService;
import com.openpayd.conversion.service.ConversionServiceImpl;
import com.openpayd.exchange.config.ExchangeConfig;
import com.openpayd.exchange.service.ExchangeRateService;
import com.openpayd.exchange.service.ExchangeRateServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class ConversionConfiguration {


    @Bean
    public ConversionService conversionService(
            ConversionConfig config, RestTemplate rest){
        return new ConversionServiceImpl(config, rest);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
