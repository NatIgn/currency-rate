package com.egt.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableScheduling
public class AppConfig {
    @Value("${currencyrateservice.base.url}")
    private String currencyRateServiceUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl(currencyRateServiceUrl).build();
    }
}
