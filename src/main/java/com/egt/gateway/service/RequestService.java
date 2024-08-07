package com.egt.gateway.service;

import com.egt.gateway.entity.RequestEntity;

public interface RequestService {
    void save(RequestEntity request);

    RequestEntity findById(String id);
}
