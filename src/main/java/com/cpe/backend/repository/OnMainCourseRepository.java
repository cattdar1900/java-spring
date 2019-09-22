package com.cpe.backend.repository;



import com.cpe.backend.entity.OnMainCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface OnMainCourseRepository extends JpaRepository<OnMainCourse, Long> {

    OnMainCourse findById(long id);
}