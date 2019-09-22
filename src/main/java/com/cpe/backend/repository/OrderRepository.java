package com.cpe.backend.repository;



import com.cpe.backend.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(long id);
}