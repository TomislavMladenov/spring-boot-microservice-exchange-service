package com.openpayd.conversion.service;

import com.openpayd.conversion.config.ConversionConfig;
import com.openpayd.conversion.model.Conversion;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
@AllArgsConstructor
@Slf4j
public class ConversionServiceImpl implements ConversionService {

    private ConversionConfig config;
    private RestTemplate rest;

    @Override
    public Conversion makeTransaction(Float sourceAmount, String sourceCurrency, String targetCurrency) {
        String conversionUri = buildConversionUrl(sourceAmount, sourceCurrency, targetCurrency);
        log.info("Conversion uri = {}", conversionUri);
        Map<?, ?> response = rest.getForObject(conversionUri, Map.class);
        log.debug("Getting value for conversion {}", response);
        return null;
    }

    private String buildConversionUrl(Float sourceAmount, String sourceCurrency, String targetCurrency){
        return UriComponentsBuilder.newInstance()
                .host(config.getBaseUrl())
                .path(config.getLiveEndpoint())
                .queryParam("access_key", config.getAccessKey())
                .queryParam("from", sourceCurrency)
                .queryParam("to", targetCurrency)
                .queryParam("amount",sourceAmount)
                .build()
                .toUriString();
    }
}
