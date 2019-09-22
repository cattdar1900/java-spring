package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.TypeMenu;
import com.cpe.backend.repository.TypeMenuRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class TypeMenuController {

    @Autowired
    private final TypeMenuRepository TypeMenuRepository;

    public TypeMenuController(TypeMenuRepository TypeMenuRepository) {
        this.TypeMenuRepository = TypeMenuRepository;
    }

    @GetMapping("/TypeMenu")
    public Collection<TypeMenu> TypeMenus() {
        return TypeMenuRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/TypeMenu/{id}")
    public Optional<TypeMenu> TypeMenus(@PathVariable Long id) {
        Optional<TypeMenu> TypeMenu = TypeMenuRepository.findById(id);
        return TypeMenu;
    }



}