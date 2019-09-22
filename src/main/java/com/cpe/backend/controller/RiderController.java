package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Rider;
import com.cpe.backend.repository.RiderRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class RiderController {

    @Autowired
    private final RiderRepository RiderRepository;

    public RiderController(RiderRepository RiderRepository) {
        this.RiderRepository = RiderRepository;
    }

    @GetMapping("/Rider")
    public Collection<Rider> Riders() {
        return RiderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Rider/{id}")
    public Optional<Rider> Riders(@PathVariable Long id) {
        Optional<Rider> Rider = RiderRepository.findById(id);
        return Rider;
    }



}