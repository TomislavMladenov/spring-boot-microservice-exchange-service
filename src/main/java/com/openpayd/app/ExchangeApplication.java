package com.openpayd.app;

import com.openpayd.conversion.config.ConversionConfiguration;
import com.openpayd.exchange.config.ExchangeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		ExchangeConfiguration.class,
		ConversionConfiguration.class
})
public class ExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

}
