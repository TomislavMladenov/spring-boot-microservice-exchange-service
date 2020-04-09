package com.openpayd.exchange.config;

import com.openpayd.exchange.dao.ExchangeRateRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
        "com.openpayd.exchange.service", "com.openpayd.exchange.api"
})
@EnableJpaRepositories(basePackages = "com.openpayd.exchange.dao")
@EntityScan(basePackages = "com.openpayd.exchange.model")
public class ExchangeConfiguration {

    @Bean
    public ExchangeRateRepository exchangeRateRepository () {
        return new ExchangeRateRepository();
    }

}
