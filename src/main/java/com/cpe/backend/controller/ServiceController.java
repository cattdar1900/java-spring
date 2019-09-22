package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Service;
import com.cpe.backend.repository.ServiceRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class ServiceController {

    @Autowired
    private final ServiceRepository ServiceRepository;

    public ServiceController(ServiceRepository ServiceRepository) {
        this.ServiceRepository = ServiceRepository;
    }

    @GetMapping("/Service")
    public Collection<Service> Services() {
        return ServiceRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Service/{id}")
    public Optional<Service> Services(@PathVariable Long id) {
        Optional<Service> Service = ServiceRepository.findById(id);
        return Service;
    }



}