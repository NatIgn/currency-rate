package com.egt.gateway.service;

import com.egt.gateway.entity.CurrencyExchangeRate;

import java.util.Date;
import java.util.List;

public interface CurrencyExchangeRateService {
    void save(CurrencyExchangeRate currencyExchangeRate);
    CurrencyExchangeRate getByCurrencyCode(String currencyCode);
    List<CurrencyExchangeRate> getHisoryCurrencyDataByCurrencyCode(String currencyCode, Date startDate, Date endDate);

}
