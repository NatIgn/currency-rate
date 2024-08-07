package com.egt.gateway.service;

import com.egt.gateway.entity.Currency;

import java.util.List;

public interface CurrencyService {

    void save(Currency currency);

    Currency findById(int id);

    Currency findByCode(String code);

    List<Currency> findAll();
}
