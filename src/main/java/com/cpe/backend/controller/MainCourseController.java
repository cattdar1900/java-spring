package com.cpe.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.cpe.backend.controller.CORS;


import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cpe.backend.entity.MainCourse;
import com.cpe.backend.repository.MainCourseRepository;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = CORS.avaliable )
@RestController
public class MainCourseController {

    @Autowired
    private final MainCourseRepository MainCourseRepository;

    public MainCourseController(MainCourseRepository MainCourseRepository) {
        this.MainCourseRepository = MainCourseRepository;
    }

    

    @GetMapping("/MainCourse")
    public Collection<MainCourse> MainCourses() {
        return MainCourseRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/MainCourse/{id}")
    public Optional<MainCourse> MainCourses(@PathVariable Long id) {
        Optional<MainCourse> MainCourse = MainCourseRepository.findById(id);
        return MainCourse;
    }
   

}