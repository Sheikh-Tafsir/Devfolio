package com.example.demo.service.service;

import com.example.demo.service.domain.ServiceEntity;
import com.example.demo.service.domain.ServiceRequest;
import com.example.demo.service.domain.ServiceResponse;

import java.util.List;

public interface ServiceService {
    ServiceResponse create(ServiceRequest serviceRequest);

    List<ServiceEntity> viewAll();
}
