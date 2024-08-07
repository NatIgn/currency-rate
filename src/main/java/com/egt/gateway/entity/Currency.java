package com.egt.gateway.entity;

import jakarta.persistence.*;

@Entity
@Table(name="currency")
public class Currency {

    @Id
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;

    public Currency() {

    }

    public Currency(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
