package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.cpe.backend.controller.CORS;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.OnMatRes;
import com.cpe.backend.repository.OnMatResRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable )
@RestController
public class OnMatResController {

    @Autowired
    private final OnMatResRepository OnMatResRepository;

    public OnMatResController(OnMatResRepository OnMatResRepository) {
        this.OnMatResRepository = OnMatResRepository;
    }

    

    @GetMapping("/OnMatRes")
    public Collection<OnMatRes> OnMatRess() {
        return OnMatResRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnMatRes/{id}")
    public Optional<OnMatRes> OnMatRess(@PathVariable Long id) {
        Optional<OnMatRes> OnMatRes = OnMatResRepository.findById(id);
        return OnMatRes;
    }
   

}