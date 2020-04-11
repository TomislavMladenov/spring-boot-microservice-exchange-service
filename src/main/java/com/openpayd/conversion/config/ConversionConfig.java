package com.openpayd.conversion.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "openpayd.exchange.server.conversion")
@Getter
@Setter
@NoArgsConstructor
public class ConversionConfig {

    private String accessKey;
    private String baseUrl;
    private String liveEndpoint;
}
