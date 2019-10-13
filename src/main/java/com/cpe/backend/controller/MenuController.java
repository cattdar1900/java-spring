package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Menu;
import com.cpe.backend.repository.MenuRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable )
@RestController
public class MenuController {

    @Autowired
    private final MenuRepository MenuRepository;

    public MenuController(MenuRepository MenuRepository) {
        this.MenuRepository = MenuRepository;
    }

    @GetMapping("/Menu")
    public Collection<Menu> Menus() {
        return MenuRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Menu/{id}")
    public Optional<Menu> Menus(@PathVariable Long id) {
        Optional<Menu> Menu = MenuRepository.findById(id);
        return Menu;
    }
    @GetMapping("/Menu/restaurant/{id}")
    public Collection<Menu> allMenu(@PathVariable Long id){
        return MenuRepository.findMenuByResID(id);
    }



}