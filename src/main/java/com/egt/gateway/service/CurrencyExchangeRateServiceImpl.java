package com.egt.gateway.service;

import com.egt.gateway.dao.CurrencyExchangeRateDAO;
import com.egt.gateway.entity.CurrencyExchangeRate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CurrencyExchangeRateServiceImpl implements CurrencyExchangeRateService {
    private CurrencyExchangeRateDAO currencyExchangeRateDAO;

    @Autowired
    public CurrencyExchangeRateServiceImpl(CurrencyExchangeRateDAO currencyExchangeRateDAO) {
        this.currencyExchangeRateDAO = currencyExchangeRateDAO;
    }

    @Transactional
    @Override
    public void save(CurrencyExchangeRate currencyExchangeRate) {
        this.currencyExchangeRateDAO.save(currencyExchangeRate);
    }

    @Override
    public CurrencyExchangeRate getByCurrencyCode(String currencyCode) {
        return this.currencyExchangeRateDAO.getByCurrencyCode(currencyCode);
    }

    @Override
    public List<CurrencyExchangeRate> getHisoryCurrencyDataByCurrencyCode(String currencyCode, Date startDate, Date endDate) {
        return List.of();
    }
}
