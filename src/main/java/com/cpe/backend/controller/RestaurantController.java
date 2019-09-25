package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Restaurant;
import com.cpe.backend.repository.RestaurantRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "'http://localhost:8100")
@RestController
public class RestaurantController {

    @Autowired
    private final RestaurantRepository RestaurantRepository;

    public RestaurantController(RestaurantRepository RestaurantRepository) {
        this.RestaurantRepository = RestaurantRepository;
    }

    @GetMapping("/Restaurant")
    public Collection<Restaurant> Restaurants() {
        return RestaurantRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Restaurant/{id}")
    public Optional<Restaurant> Restaurants(@PathVariable Long id) {
        Optional<Restaurant> Restaurant = RestaurantRepository.findById(id);
        return Restaurant;
    }



}