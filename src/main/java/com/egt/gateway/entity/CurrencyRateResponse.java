package com.egt.gateway.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public class CurrencyRateResponse {
    private String success;
    private Timestamp timestamp;
    private String base;
    private Date date;
    private Map<String, Double> rates;

    public CurrencyRateResponse() {

    }

    public CurrencyRateResponse(String success, Timestamp timestamp, String base, Date date, Map<String, Double> rates) {
        this.success = success;
        this.timestamp = timestamp;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRate(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "CurrencyRateResponse{" +
                "success='" + success + '\'' +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", date=" + date +
                ", rates=" + rates +
                '}';
    }
}
