package com.egt.gateway.dao;

import com.egt.gateway.entity.RequestEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDAOImpl implements RequestDAO {

    private EntityManager entityManager;

    @Autowired
    public RequestDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(RequestEntity request) {
        this.entityManager.persist(request);
    }

    @Override
    public RequestEntity findById(String id) {
        return this.entityManager.find(RequestEntity.class, id);
    }
}
