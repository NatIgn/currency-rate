package com.egt.gateway.service;

import com.egt.gateway.entity.Currency;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CurrencyService {
    @Transactional
    void save(Currency currency);

    Currency findById(int id);

    Currency findByCode(String code);

    List<Currency> findAll();
}
