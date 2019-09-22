package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.OnMenu;
import com.cpe.backend.repository.OnMenuRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class OnMenuController {

    @Autowired
    private final OnMenuRepository OnMenuRepository;

    public OnMenuController(OnMenuRepository OnMenuRepository) {
        this.OnMenuRepository = OnMenuRepository;
    }

    @GetMapping("/OnMenu")
    public Collection<OnMenu> OnMenus() {
        return OnMenuRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnMenu/{id}")
    public Optional<OnMenu> OnMenus(@PathVariable Long id) {
        Optional<OnMenu> OnMenu = OnMenuRepository.findById(id);
        return OnMenu;
    }



}