package com.egt.gateway.service;

import com.egt.gateway.dao.CurrencyDAO;
import com.egt.gateway.entity.Currency;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CurrencyServiceImpl implements CurrencyService {

    private CurrencyDAO currencyDAO;

    @Autowired
    public CurrencyServiceImpl(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @Override
    @Transactional
    public void save(Currency currency) {
        this.currencyDAO.save(currency);
    }

    @Override
    public Currency findById(int id) {
        return this.currencyDAO.findById(id);
    }

    @Override
    public Currency findByCode(String code) {
        return this.currencyDAO.findByCode(code);
    }

    @Override
    public List<Currency> findAll() {
        return this.currencyDAO.findAll();
    }
}
