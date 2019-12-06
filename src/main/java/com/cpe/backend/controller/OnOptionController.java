package com.cpe.backend.controller;


import com.cpe.backend.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.OnOption;
import com.cpe.backend.repository.OnOptionRepository;

import javax.validation.Valid;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class OnOptionController {

    @Autowired
    private final OnOptionRepository OnOptionRepository;

    public OnOptionController(OnOptionRepository OnOptionRepository) {
        this.OnOptionRepository = OnOptionRepository;
    }

    @GetMapping("/OnOption")
    public Collection<OnOption> OnOptions() {
        return OnOptionRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnOption/{id}")
    public Optional<OnOption> OnOptions(@PathVariable Long id) {
        Optional<OnOption> OnOption = OnOptionRepository.findById(id);
        return OnOption;
    }
// Test Query
    @GetMapping("/FindOnOptionByOrderId/{id}")
    public Collection<OnOption> finOpByOrId(@PathVariable Long id) {
        Collection<OnOption> OnOption = OnOptionRepository.findOnOptionByOrderId(id);
        return OnOption;
    }

    @PutMapping("/ReceiveOnOptionTimeStamp/{id}")
    public ResponseEntity<OnOption> receiveOnOptionTimeStamp(@PathVariable(value = "id") Long id, @Valid @RequestBody OnOption option) throws ResourceNotFoundException {
        OnOption onOption1 = OnOptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        Date date = new Date();
        onOption1.setReceivedDate(date);
        final OnOption receiveOnOptionTimeStamp = OnOptionRepository.save(onOption1);
        return ResponseEntity.ok(receiveOnOptionTimeStamp);
    }



}