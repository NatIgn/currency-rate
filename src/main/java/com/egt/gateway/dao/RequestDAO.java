package com.egt.gateway.dao;

import com.egt.gateway.entity.RequestEntity;

public interface RequestDAO {
    void save(RequestEntity request);

    RequestEntity findById(String id);
}
