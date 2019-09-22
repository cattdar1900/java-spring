package com.cpe.backend.repository;



import com.cpe.backend.entity.TypeFood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface TypeFoodRepository extends JpaRepository<TypeFood, Long> {

    TypeFood findById(long id);
}