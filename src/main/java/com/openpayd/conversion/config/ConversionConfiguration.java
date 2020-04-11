package com.openpayd.conversion.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.openpayd.conversion.service", "com.openpayd.conversion.api"
})
@EnableConfigurationProperties(ConversionConfig.class)
public class ConversionConfiguration {

}
