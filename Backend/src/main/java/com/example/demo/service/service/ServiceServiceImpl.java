package com.example.demo.service.service;

import com.example.demo.service.domain.ServiceEntity;
import com.example.demo.service.domain.ServiceRequest;
import com.example.demo.service.domain.ServiceResponse;
import com.example.demo.service.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.service.constant.Message.*;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public ServiceResponse create(ServiceRequest serviceRequest){
        ServiceEntity serviceEntity = new ServiceEntity(
                serviceRequest.getUserId(),
                serviceRequest.getName(),
                serviceRequest.getDescription()
        );

        try{
            serviceRepository.save(serviceEntity);
            return new ServiceResponse(SERVICE_SAVED_SUCCESSFULLY.getMessage());
        }
        catch (Exception e){
            System.out.println(e);
            return new ServiceResponse(SERVICE_SAVE_FAILED.getMessage());
        }
    }

    @Override
    public List<ServiceEntity> viewAll(){
        return serviceRepository.findAll();
    }

}