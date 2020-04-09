package com.openpayd.conversion.config;

import com.openpayd.conversion.dao.ConversionRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {
        "com.openpayd.conversion.service", "com.openpayd.conversion.api"
})
@EnableJpaRepositories(basePackages = "com.openpayd.conversion.dao")
@EntityScan(basePackages = "com.openpayd.conversion.model")
public class ConversionConfiguration {

    @Bean
    public ConversionRepository conversionRepository(){
        return new ConversionRepository();
    }
}
