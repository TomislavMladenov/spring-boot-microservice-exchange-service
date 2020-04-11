package com.openpayd.conversion.config;

import com.openpayd.conversion.service.ConversionService;
import com.openpayd.conversion.service.ConversionServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {
        "com.openpayd.conversion.service", "com.openpayd.conversion.api"
})
@EnableConfigurationProperties(ConversionConfig.class)
public class ConversionConfiguration {

//    @Bean
//    public ConversionService conversionService(ConversionConfig config, RestTemplate rest){
//        return new ConversionServiceImpl(config, rest);
//    }

}
