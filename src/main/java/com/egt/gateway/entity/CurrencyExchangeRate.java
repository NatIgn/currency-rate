package com.egt.gateway.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="currency_exchange_rate")
public class CurrencyExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="curr_exch_rate_id")
    private int CurrExchRateid;

    @ManyToOne
    @JoinColumn(name="from_currency", insertable = true, updatable = true)
    private Currency fromCurrencyId;

    @ManyToOne
    @JoinColumn(name="to_currency", insertable = true, updatable = true)
    private Currency toCurrencyId;

    @Column(name="rate_date")
    private Date rateDate;

    @Column(name="exchange_rate")
    private double exchangeRate;

    public  CurrencyExchangeRate() {

    }

    public CurrencyExchangeRate(Currency toCurrencyId, Currency fromCurrencyId, Date rateDate, double exchangeRate) {
        this.toCurrencyId = toCurrencyId;
        this.fromCurrencyId = fromCurrencyId;
        this.rateDate = rateDate;
        this.exchangeRate = exchangeRate;
    }

    public Currency getFromCurrencyId() {
        return fromCurrencyId;
    }

    public void setFromCurrencyId(Currency fromCurrencyId) {
        this.fromCurrencyId = fromCurrencyId;
    }

    public int getCurrExchRateid() {
        return CurrExchRateid;
    }

    public void setCurrExchRateid(int currExchRateid) {
        CurrExchRateid = currExchRateid;
    }

    public Currency getToCurrencyId() {
        return toCurrencyId;
    }

    public void setToCurrencyId(Currency toCurrencyId) {
        this.toCurrencyId = toCurrencyId;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }
}
