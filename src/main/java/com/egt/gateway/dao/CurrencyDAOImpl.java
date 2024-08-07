package com.egt.gateway.dao;

import com.egt.gateway.entity.Currency;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyDAOImpl implements CurrencyDAO {

    private EntityManager entityManager;

    @Autowired
    public CurrencyDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Currency currency) {
        entityManager.persist(currency);
    }

    @Override
    public Currency findById(int id) {

        return entityManager.find(Currency.class, id);
    }

    @Override
    public Currency findByCode(String code) {
        TypedQuery<Currency> currencies = entityManager.createQuery("FROM Currency WHERE code=:code", Currency.class);
        currencies.setParameter("code", code);
        return currencies.getSingleResult();
    }


    @Override
    public List<Currency> findAll() {
        TypedQuery<Currency> allCurrencies = entityManager.createQuery("FROM Currency", Currency.class);
        return allCurrencies.getResultList();
    }
}
