package com.example.demo.service.controller;

import com.example.demo.service.domain.ServiceEntity;
import com.example.demo.service.domain.ServiceRequest;
import com.example.demo.service.domain.ServiceResponse;
import com.example.demo.service.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceController {
    private final ServiceService serviceService;
    @PostMapping("/create")
    public ServiceResponse create(@RequestBody ServiceRequest serviceRequest) {
        return serviceService.create(serviceRequest);
    }
    @GetMapping("viewall")
    public List<ServiceEntity> viewAll(){
        return serviceService.viewAll();
    }
}
