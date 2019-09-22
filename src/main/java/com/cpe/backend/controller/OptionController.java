package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Option;
import com.cpe.backend.repository.OptionRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class OptionController {

    @Autowired
    private final OptionRepository OptionRepository;

    public OptionController(OptionRepository OptionRepository) {
        this.OptionRepository = OptionRepository;
    }

    @GetMapping("/Option")
    public Collection<Option> Options() {
        return OptionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Option/{id}")
    public Optional<Option> Options(@PathVariable Long id) {
        Optional<Option> Option = OptionRepository.findById(id);
        return Option;
    }



}