package com.egt.gateway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="request")
public class RequestEntity {

    @Id
    @Column(name="request_id")
    private String requestId;

    @Column(name="service_id")
    private String serviceId;

    @Column(name="timestamp")
    private Timestamp timestamp;

    @Column(name="end_client_id")
    private String endClientId;

    public RequestEntity() {

    }

    public RequestEntity(String serviceId, String requestId, Timestamp timestamp, String endClientId) {
        this.serviceId = serviceId;
        this.requestId = requestId;
        this.timestamp = timestamp;
        this.endClientId = endClientId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getEndClientId() {
        return endClientId;
    }

    public void setEndClientId(String endClientId) {
        this.endClientId = endClientId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", timestamp=" + timestamp +
                ", endClientId='" + endClientId + '\'' +
                '}';
    }
}
