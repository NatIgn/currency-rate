package com.egt.gateway.dao;

import com.egt.gateway.entity.Currency;
import com.egt.gateway.entity.CurrencyExchangeRate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CurrencyExchangeRateDAOImpl implements CurrencyExchangeRateDAO {

    private EntityManager entityManager;

    @Autowired
    public CurrencyExchangeRateDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(CurrencyExchangeRate currencyExchangeRate) {
        entityManager.persist(currencyExchangeRate);
    }

    @Override
    public CurrencyExchangeRate getByCurrencyCode(String currencyCode) {
//        TypedQuery<CurrencyExchangeRate> query = entityManager.createQuery("FROM CurrencyExchangeRate WHERE fromCurrencyId = :currencyCode", CurrencyExchangeRate.class);
        TypedQuery<CurrencyExchangeRate> query = entityManager.createQuery("FROM CurrencyExchangeRate WHERE fromCurrencyId.code = :currencyCode  order by rateDate DESC", CurrencyExchangeRate.class);
        query.setParameter("currencyCode", currencyCode);
        query.setMaxResults(1);
        return query.getSingleResult();
    }

    @Override
    public List<CurrencyExchangeRate> getHisoryCurrencyDataByCurrencyCode(String currencyCode, Date startDate, Date endDate) {
        TypedQuery<CurrencyExchangeRate> query = entityManager.createQuery("FROM CurrencyExchangeRate WHERE fromCurrencyId.code = :currencyCode AND rateDate between :startDate and :endDate", CurrencyExchangeRate.class);
        query.setParameter("currencyCode", currencyCode);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }
}
