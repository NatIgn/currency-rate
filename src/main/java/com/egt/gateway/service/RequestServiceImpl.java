package com.egt.gateway.service;

import com.egt.gateway.dao.RequestDAO;
import com.egt.gateway.entity.RequestEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {

    private RequestDAO requestDAO;

    @Autowired
    public RequestServiceImpl(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    @Transactional
    @Override
    public void save(RequestEntity request) {
        this.requestDAO.save(request);
    }

    @Override
    public RequestEntity findById(String id) {
        return this.requestDAO.findById(id);
    }
}
