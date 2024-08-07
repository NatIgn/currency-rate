package com.egt.gateway.dao;

import com.egt.gateway.entity.Currency;
import com.egt.gateway.entity.CurrencyExchangeRate;

import java.util.Date;
import java.util.List;

public interface CurrencyExchangeRateDAO {

    void save(CurrencyExchangeRate currencyExchangeRate);
    CurrencyExchangeRate getByCurrencyCode(String currencyCode);
    List<CurrencyExchangeRate> getHisoryCurrencyDataByCurrencyCode(String currencyCode, Date startDate, Date endDate);

}
