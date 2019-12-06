package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.OnMatType;
import com.cpe.backend.repository.OnMatTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable )
@RestController
public class OnMatTypeController {

    @Autowired
    private final OnMatTypeRepository OnMatTypeRepository;

    public OnMatTypeController(OnMatTypeRepository OnMatTypeRepository) {
        this.OnMatTypeRepository = OnMatTypeRepository;
    }

    @GetMapping("/OnMatType")
    public Collection<OnMatType> OnMatTypes() {
        return OnMatTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnMatType/{id}")
    public Optional<OnMatType> OnMatTypes(@PathVariable Long id) {
        Optional<OnMatType> OnMatType = OnMatTypeRepository.findById(id);
        return OnMatType;
    }
   



}