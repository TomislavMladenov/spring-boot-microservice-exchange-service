package com.openpayd.exchange.config;

import com.openpayd.exchange.service.ExchangeRateService;
import com.openpayd.exchange.service.ExchangeRateServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {
        "com.openpayd.exchange.service", "com.openpayd.exchange.api"
})
@EntityScan(basePackages = "com.openpayd.exchange.model")
@EnableConfigurationProperties(ExchangeConfig.class)
public class ExchangeConfiguration {

    @Bean
    public ExchangeRateService exchangeRateService(
            ExchangeConfig config, RestTemplate rest){
        return new ExchangeRateServiceImpl(config, rest);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
