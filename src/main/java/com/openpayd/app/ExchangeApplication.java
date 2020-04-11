package com.openpayd.app;

import com.openpayd.conversion.config.ConversionConfiguration;
import com.openpayd.exchange.config.ExchangeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {
	"com.openpayd.common.exception.handler"
})
@Import({
		ExchangeConfiguration.class,
		ConversionConfiguration.class
})
public class ExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
