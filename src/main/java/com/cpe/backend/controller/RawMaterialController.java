package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.RawMaterial;
import com.cpe.backend.repository.RawMaterialRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class RawMaterialController {

    @Autowired
    private final RawMaterialRepository RawMaterialRepository;

    public RawMaterialController(RawMaterialRepository RawMaterialRepository) {
        this.RawMaterialRepository = RawMaterialRepository;
    }

    @GetMapping("/RawMaterial")
    public Collection<RawMaterial> RawMaterials() {
        return RawMaterialRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/RawMaterial/{id}")
    public Optional<RawMaterial> RawMaterials(@PathVariable Long id) {
        Optional<RawMaterial> RawMaterial = RawMaterialRepository.findById(id);
        return RawMaterial;
    }



}