package com.egt.gateway.entity;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

@XmlRootElement(name="history")
@Component
public class History {

    @XmlAttribute(name="consumer")
    private String consumer;
    @XmlAttribute(name="currency")
    private String currency;

    @XmlAttribute(name="period")
    private int period;

    public History() {

    }

    public History(String consumer, String currency, int period) {
        this.consumer = consumer;
        this.currency = currency;
        this.period = period;
    }


    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
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
        return "History{" +
                "consumer='" + consumer + '\'' +
                ", currency='" + currency + '\'' +
                ", period=" + period +
                '}';
    }
}
