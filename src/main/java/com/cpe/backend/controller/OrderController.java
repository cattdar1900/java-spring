package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Order;
import com.cpe.backend.repository.OrderRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class OrderController {

    @Autowired
    private final OrderRepository OrderRepository;

    public OrderController(OrderRepository OrderRepository) {
        this.OrderRepository = OrderRepository;
    }

    @GetMapping("/Order")
    public Collection<Order> Orders() {
        return OrderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Order/{id}")
    public Optional<Order> Orders(@PathVariable Long id) {
        Optional<Order> Order = OrderRepository.findById(id);
        return Order;
    }



}