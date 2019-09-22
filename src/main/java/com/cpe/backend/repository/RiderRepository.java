package com.cpe.backend.repository;



import com.cpe.backend.entity.Rider;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface RiderRepository extends JpaRepository<Rider, Long> {

    Rider findById(long id);
    Rider findByName(String name);
}