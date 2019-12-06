package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.cpe.backend.controller.CORS;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.OnMainType;
import com.cpe.backend.repository.OnMainTypeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable )
@RestController
public class OnMainTypeController {

    @Autowired
    private final OnMainTypeRepository OnMainTypeRepository;

    public OnMainTypeController(OnMainTypeRepository OnMainTypeRepository) {
        this.OnMainTypeRepository = OnMainTypeRepository;
    }

    

    @GetMapping("/OnMainType")
    public Collection<OnMainType> OnMainTypes() {
        return OnMainTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnMainType/{id}")
    public Optional<OnMainType> OnMainTypes(@PathVariable Long id) {
        Optional<OnMainType> OnMainType = OnMainTypeRepository.findById(id);
        return OnMainType ;
    }
}