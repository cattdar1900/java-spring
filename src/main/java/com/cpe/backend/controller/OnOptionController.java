package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.OnOption;
import com.cpe.backend.repository.OnOptionRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class OnOptionController {

    @Autowired
    private final OnOptionRepository OnOptionRepository;

    public OnOptionController(OnOptionRepository OnOptionRepository) {
        this.OnOptionRepository = OnOptionRepository;
    }

    @GetMapping("/OnOption")
    public Collection<OnOption> OnOptions() {
        return OnOptionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnOption/{id}")
    public Optional<OnOption> OnOptions(@PathVariable Long id) {
        Optional<OnOption> OnOption = OnOptionRepository.findById(id);
        return OnOption;
    }



}