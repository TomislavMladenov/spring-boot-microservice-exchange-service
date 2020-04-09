package com.openpayd.exchange.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openpayd.exchange.server")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeConfig {

    private String accessKey;
    private String baseUrl;
    private String liveEndpoint;


}
