package com.cpe.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.MainCourse;
import com.cpe.backend.entity.OnMainCourse;
import com.cpe.backend.repository.OnMainCourseRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable)
@RestController
public class OnMainCourseController {

    @Autowired
    private final OnMainCourseRepository OnMainCourseRepository;
    


    public OnMainCourseController(OnMainCourseRepository OnMainCourseRepository) {
        this.OnMainCourseRepository = OnMainCourseRepository;
    }

    @GetMapping("/OnMainCourse")
    public Collection<OnMainCourse> OnMainCourses() {
        return OnMainCourseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OnMainCourse/{id}")
    public Optional<OnMainCourse> OnMainCourses(@PathVariable Long id) {
        Optional<OnMainCourse> OnMainCourse = OnMainCourseRepository.findById(id);
        return OnMainCourse;
    }
    @GetMapping("/MainCourse/byRestaurant/{id}")
    public Collection<MainCourse> checkMain(@PathVariable Long id){
        return OnMainCourseRepository.findMainCourseByMarket(id);
    }


}