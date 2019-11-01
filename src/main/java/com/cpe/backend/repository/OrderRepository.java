package com.cpe.backend.repository;

import java.util.Collection;

import com.cpe.backend.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(long id);

    @Query(value ="SELECT * FROM ORDERS WHERE ORDERS.RIDER_ID = :id AND ORDERS.STATUS = 'ดำเนินการเสร็จสิ้น' ",
     nativeQuery = true)
     Collection<Order> findByRiderId(@Param("id") String id);
}