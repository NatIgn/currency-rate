package com.egt.gateway.entity;

import java.sql.Timestamp;

public class RestRequestObj {
    private String requestId;
    private Timestamp timestamp;
    private String clientId;
    private String currency;
    private int period;

    public RestRequestObj() {

    }

    public RestRequestObj(String requestId, Timestamp timestamp, String clientId, String currency, int period) {
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.clientId = clientId;
        this.currency = currency;
        this.period = period;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "RequestObj{" +
                "requestId='" + requestId + '\'' +
                ", timestamp=" + timestamp +
                ", clientId='" + clientId + '\'' +
                ", currency='" + currency + '\'' +
                ", period=" + period +
                '}';
    }
}
