package com.egt.gateway.entity;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.stereotype.Component;

@XmlRootElement(name="get")
@Component
public class Get {
    @XmlAttribute(name="consumer")
    private String consumerId;

    @XmlElement(name="currency")
    private String currency;

    public Get() {

    }


    public Get(String consumerId, String currency) {
        this.consumerId = consumerId;
        this.currency = currency;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Get{" +
                "consumerId='" + consumerId + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
