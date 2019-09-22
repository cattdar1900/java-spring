package com.cpe.backend.repository;



import com.cpe.backend.entity.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findById(long id);
}