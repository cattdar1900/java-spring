package com.cpe.backend.repository;



import com.cpe.backend.entity.MainCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface MainCourseRepository extends JpaRepository<MainCourse, Long> {

    MainCourse findById(long id);
}