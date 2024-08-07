package com.egt.gateway.service;

import com.egt.gateway.dao.CurrencyDAO;
import com.egt.gateway.dao.CurrencyExchangeRateDAO;
import com.egt.gateway.entity.Currency;
import com.egt.gateway.entity.CurrencyExchangeRate;
import com.egt.gateway.entity.CurrencyRateResponse;
import com.egt.gateway.entity.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.Map;

@Service
public class CurrencyRateService {
    private WebClient webClient;
    @Value("${access_key}")
    private String accessKey;

    private CurrencyService currencyService;
    private CurrencyExchangeRateService currencyExchangeRateService;

    @Autowired
    public CurrencyRateService(WebClient webClient, CurrencyService currencyService, CurrencyExchangeRateService currencyExchangeRateService) {
        this.webClient = webClient;
        this.currencyService = currencyService;
        this.currencyExchangeRateService = currencyExchangeRateService;
    }

    @Scheduled(fixedRateString="${secondsToRetry}")
    public void getCurrencyRate() {
        CurrencyRateResponse currencyRateResponse = webClient.get().uri("/latest?access_key=" +accessKey).retrieve().bodyToMono(CurrencyRateResponse.class).retryWhen(
                Retry.backoff(2, Duration.ofMillis(25))
        ).block();;
        System.out.println(currencyRateResponse.getRates());

        Map<String, Double> rates = currencyRateResponse.getRates();

        for(String key: rates.keySet()) {
//            Currency toCurrencyId, Currency fromCurrencyId, Date rateDate, double exchangeRate
            Currency toCurrency = this.currencyService.findByCode(key);
            Currency fromCurrency = this.currencyService.findByCode(currencyRateResponse.getBase());
            CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate(toCurrency, fromCurrency, currencyRateResponse.getDate(), rates.get(key));
            this.currencyExchangeRateService.save(currencyExchangeRate);
        }
    }

    public void getCurrencySymbols() {
        CurrencyResponse currencyResponse = webClient.get().uri("/symbols?access_key="+accessKey).retrieve().bodyToMono(CurrencyResponse.class).block();

        System.out.println(currencyResponse);
        Map<String, String> currencies =  currencyResponse.getSymbols();
        for(String key : currencies.keySet()) {
            Currency currency = new Currency(key,currencies.get(key));
            this.currencyService.save(currency);
        }

    }
}
