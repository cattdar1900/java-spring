package com.cpe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.Rider;
import com.cpe.backend.repository.RiderRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class RiderController {

    @Autowired
    private final RiderRepository RiderRepository;

    public RiderController(RiderRepository RiderRepository) {
        this.RiderRepository = RiderRepository;
    }

    @GetMapping("/Rider")
    public Collection<Rider> Riders() {
        return RiderRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Rider/{id}")
    public Optional<Rider> Riders(@PathVariable Long id) {
        Optional<Rider> Rider = RiderRepository.findById(id);
        return Rider;
    }
    @RequestMapping(value = "/Rider/login",method = RequestMethod.POST)
    public String Login(@RequestBody Map<String, String> body){
        Rider UserU = RiderRepository.findById(body.get("username")).get();
        String U = UserU.getPassword();
        String P = body.get("password");
        System.out.println(body);
        System.out.println(U);
        System.out.println(P);
        if(U.equals(P)){
            return body.get("username");
        }
        return "Error not Found username or password";
    }


}