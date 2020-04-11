package com.openpayd.conversion.service;

import com.openpayd.common.exception.CommonException;
import com.openpayd.conversion.config.ConversionConfig;
import com.openpayd.conversion.model.Conversion;
import jdk.internal.jline.internal.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.Optional;

@Service
public class ConversionServiceImpl implements ConversionService {

    private ConversionConfig config;
    private RestTemplate rest;


    @Override
    public Conversion makeTransaction(Float sourceAmount, String sourceCurrency, String targetCurrency) {
        String conversionUri = buildConversionUrl(sourceAmount, sourceCurrency, targetCurrency);
        System.out.println(conversionUri);
        Map response = rest.getForObject(conversionUri, Map.class);
        Log.debug("Getting value for conversion", "Test");
        return get;
    }

    private CommonException<String> getConversion(Map response, String "ssss"){

        return new
    }

    private Optional<String> getConversion(Map response, String ...){
        
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
