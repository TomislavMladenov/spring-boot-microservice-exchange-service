package com.openpayd.conversion.dao;

import com.openpayd.conversion.model.Conversion;
import com.openpayd.exchange.model.ExchangeRate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConversionRepository implements ConversionDao {

    //Here we need to call the database and get the values from it...
    private List<ExchangeRate> dummyDB = new ArrayList<>();

    public ConversionRepository() {
        generateFakeDummyDB();
    }

    private void generateFakeDummyDB(){
        dummyDB.add(new ExchangeRate(1L, "EUR", "USD", BigDecimal.valueOf(1.10)));
        dummyDB.add(new ExchangeRate(2L, "EUR", "BGN", BigDecimal.valueOf(1.95)));
        dummyDB.add(new ExchangeRate(3L, "BGN", "EUR", BigDecimal.valueOf(0.52)));
        dummyDB.add(new ExchangeRate(4L, "BGN", "USD", BigDecimal.valueOf(0.86)));
    }

    @Override
    public Conversion getTransaction(Float sourceAmount, String sourceCurrency, String targetCurrency) {
        //calculate proper value ..
        Conversion conversion = new Conversion(dummyDB.get(0).getId(), dummyDB.get(0).getRate());
        return conversion;
    }
}
