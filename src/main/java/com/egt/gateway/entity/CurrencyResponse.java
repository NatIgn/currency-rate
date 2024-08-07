package com.egt.gateway.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

public class CurrencyResponse {
    private String success;
    private Map<String, String> symbols;

    public CurrencyResponse() {

    }

    public CurrencyResponse(String success, Map<String, String> symbols) {
        this.success = success;
        this.symbols = symbols;
    }

    public String getSuccess() {
        return success;
    }

    public Map<String, String> getSymbols() {
        return symbols;
    }

    public void setSymbols(Map<String, String> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "success='" + success + '\'' +
                ", symbols=" + symbols +
                '}';
    }
}
