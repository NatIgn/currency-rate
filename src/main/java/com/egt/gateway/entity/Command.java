package com.egt.gateway.entity;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.beans.factory.annotation.Autowired;

@XmlRootElement(name="command")
public class Command {

    @XmlAttribute(name="id")
    private String id;

    @XmlElement(name="get")
    private Get get;

    @XmlElement
    private History history;

    public Command() {

    }

    @Autowired
    public Command(String id, Get get, History history) {
        this.id = id;
        this.get = get;
        this.history = history;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Get getGet() {
        return get;
    }

    public void setGet(Get get) {
        this.get = get;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", get=" + get +
                ", history=" + history +
                '}';
    }
}
