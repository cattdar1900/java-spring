package com.cpe.backend.repository;



import com.cpe.backend.entity.OnOption;
import com.cpe.backend.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findById(long id);

    @Query(value = "SELECT * FROM ORDERS WHERE STATUS = 'รอดำเนินการ'",nativeQuery = true)
    Collection<Order> findOrdersByOrderStatus();

    @Query(value = "SELECT * FROM ORDERS WHERE STATUS = 'กำลังดำเนินการ' AND RIDER_ID = :rid",nativeQuery = true)
    Collection<Order> findOrdersByRiderId(@Param("rid") String rid);

    @Query(value = "SELECT * FROM ORDERS WHERE STATUS = 'ดำเนินการเสร็จสิ้น' AND RIDER_ID = :rid",nativeQuery = true)
    Collection<Order> findSuccessOrdersByRiderId(@Param("rid") String rid);
}