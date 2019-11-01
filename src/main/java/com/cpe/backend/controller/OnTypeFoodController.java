package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.cpe.backend.controller.CORS;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.OnTypeFood;
import com.cpe.backend.repository.OnTypeFoodRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable )
@RestController
public class OnTypeFoodController {

    @Autowired
    private final OnTypeFoodRepository OnTypeFoodRepository;

    public OnTypeFoodController(OnTypeFoodRepository OnTypeFoodRepository) {
        this.OnTypeFoodRepository = OnTypeFoodRepository;
    }

    

    @GetMapping("/OnTypeFood")
    public Collection<OnTypeFood> OnTypeFoods() {
        return OnTypeFoodRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnTypeFood/{id}")
    public Optional<OnTypeFood> OnTypeFoods(@PathVariable Long id) {
        Optional<OnTypeFood> OnTypeFood = OnTypeFoodRepository.findById(id);
        return OnTypeFood ;
    }
}