package com.openpayd.exchange.dao;

import java.math.BigDecimal;
import java.util.Optional;

public interface ExchangeRateDao {

    Optional<String> getExchangeRate(String from, String to);
}
