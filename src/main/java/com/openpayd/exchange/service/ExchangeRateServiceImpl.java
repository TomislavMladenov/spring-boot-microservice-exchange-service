package com.openpayd.exchange.service;

import com.openpayd.common.exception.CommonException;
import com.openpayd.exchange.config.ExchangeConfig;
import com.openpayd.exchange.exception.QuoteNotFound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private ExchangeConfig config;
    private RestTemplate rest;

    @Override
    public String getExchangeRate(String from, String to) {
        String quoteKey = from + to;
        URI exchangeUri = buildExchangeUrl(quoteKey);
        log.debug("Exchange uri = {}", exchangeUri);
        Map<String, Object> response = rest.getForObject(exchangeUri, Map.class);
        log.debug("Getting exchange value for quote key {}", quoteKey);
        return getQuote(response, quoteKey)
                .orElseThrow(() -> createQuoteNotFound(quoteKey));
    }

    private CommonException createQuoteNotFound(String quoteKey){
        log.error("No quote value found for key {}", quoteKey);
        return new QuoteNotFound(
                "Currency pair "+quoteKey + " not found! Please try with other available currency.",
                quoteKey);
    }

    private Optional<String> getQuote(Map response, String quoteKey) {
        Map<String, String> quote = (Map<String, String>) response.get("quotes");
        log.debug("Found quotes {}", quote);
        return Optional.ofNullable(String.valueOf(quote.get(quoteKey)));
    }

    private URI buildExchangeUrl(String quoteKey) {
        return UriComponentsBuilder.newInstance()
                    .scheme(config.getProtocol())
                    .host(config.getHost())
                    .path(config.getLiveEndpoint())
                    .queryParam("access_key", config.getAccessKey())
                    .query(quoteKey).build().toUri();

    }


}
