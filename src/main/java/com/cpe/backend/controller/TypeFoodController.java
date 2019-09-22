package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.TypeFood;
import com.cpe.backend.repository.TypeFoodRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class TypeFoodController {

    @Autowired
    private final TypeFoodRepository TypeFoodRepository;

    public TypeFoodController(TypeFoodRepository TypeFoodRepository) {
        this.TypeFoodRepository = TypeFoodRepository;
    }

    @GetMapping("/TypeFood")
    public Collection<TypeFood> TypeFoods() {
        return TypeFoodRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/TypeFood/{id}")
    public Optional<TypeFood> TypeFoods(@PathVariable Long id) {
        Optional<TypeFood> TypeFood = TypeFoodRepository.findById(id);
        return TypeFood;
    }



}