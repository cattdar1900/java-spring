package com.cpe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.MainCourse;
import com.cpe.backend.entity.OnResMain;
import com.cpe.backend.repository.OnResMainRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class OnResMainController {

    @Autowired
    private final OnResMainRepository OnResMainRepository;

    public OnResMainController(OnResMainRepository OnResMainRepository) {
        this.OnResMainRepository = OnResMainRepository;
    }

    @GetMapping("/OnResMain")
    public Collection<OnResMain> OnResMains() {
        return OnResMainRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnResMain/{id}")
    public Optional<OnResMain> OnResMains(@PathVariable Long id) {
        Optional<OnResMain> OnResMain = OnResMainRepository.findById(id);
        return OnResMain;
    }

   



}