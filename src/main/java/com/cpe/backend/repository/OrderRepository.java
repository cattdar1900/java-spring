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

    @Query(value ="SELECT o.ORDER_ID,o.CUS_LOCATION,o.CUS_NAME,o.DATE,o.DATE_RIDER_SUCCESS,o.NET_PRICE,o.STATUS,o.TOTAL_PRICE_DISTANCE,o.TOTAL_PRICE_FOOD,o.TOTAL_PRICE_TRANS,o.TRANS_DISTANCE,o.RIDER_ID,o.SERVICE_ID,r.NAME FROM ORDERS AS o  INNER JOIN ON_OPTION AS onp INNER JOIN OPTION AS op INNER JOIN RESTAURANT AS r on o.ORDER_ID = onp.ORDER_ID AND onp.OPTION_ID = op.OPTION_ID AND op.RESTAURANT_ID = r.RESTAURANT_ID WHERE o.RIDER_ID = :id AND o.STATUS = 'ดำเนินการเสร็จสิ้น'  ",
     nativeQuery = true)
     Collection<Object[]> findByRiderId(@Param("id") String id);


     @Query(value ="SELECT o.ORDER_ID,o.CUS_LOCATION,o.CUS_NAME,o.DATE,o.DATE_RIDER_SUCCESS,o.NET_PRICE,o.STATUS,o.TOTAL_PRICE_DISTANCE,o.TOTAL_PRICE_FOOD,o.TOTAL_PRICE_TRANS,o.TRANS_DISTANCE,o.RIDER_ID,o.SERVICE_ID,r.NAME FROM ORDERS AS o  INNER JOIN ON_OPTION AS onp INNER JOIN OPTION AS op INNER JOIN RESTAURANT AS r on o.ORDER_ID = onp.ORDER_ID AND onp.OPTION_ID = op.OPTION_ID AND op.RESTAURANT_ID = r.RESTAURANT_ID WHERE  o.STATUS = 'รอดำเนินการ'  ",
     nativeQuery = true)
     Collection<Object[]> findByRiderStatus();

}

