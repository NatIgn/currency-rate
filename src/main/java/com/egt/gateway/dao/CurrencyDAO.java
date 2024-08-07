package com.egt.gateway.dao;

import com.egt.gateway.entity.Currency;

import java.util.List;

public interface CurrencyDAO {

    void save(Currency currency);

    Currency findById(int id);

    Currency findByCode(String code);

    List<Currency> findAll();
}
