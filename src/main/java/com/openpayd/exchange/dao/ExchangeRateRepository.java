package com.openpayd.exchange.dao;

import com.openpayd.exchange.model.ExchangeRate;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ExchangeRateRepository implements ExchangeRateDao {

    public static final String ACCESS_KEY = "5e42c6fa13ff812ff6017c8266e0228e";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";

    static CloseableHttpClient httpClient = HttpClients.createDefault();

    public ExchangeRateRepository() {

    }

    @Override
    public Optional<String> getExchangeRate(String from, String to) {


        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&" + from + to);

        try {
            CloseableHttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            BigDecimal quoteRate = exchangeRates.getJSONObject("quotes").getBigDecimal(from.concat(to));

            ExchangeRate currentExchangeRate = new ExchangeRate();
            currentExchangeRate.setRate(quoteRate);
            currentExchangeRate.setFrom(from);
            currentExchangeRate.setTo(to);

            response.close();
            return Optional.ofNullable(String.valueOf(currentExchangeRate.getRate()));

        } catch (IOException | ParseException | JSONException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
