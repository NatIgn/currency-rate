package com.egt.gateway;

import com.egt.gateway.service.CurrencyRateService;
import com.egt.gateway.service.CurrencyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
//
	@Bean
	public CommandLineRunner commandLineRunner(CurrencyRateService currencyRateService) {
		return runner -> {
			currencyRateService.getCurrencyRate();
		};
	}
}
