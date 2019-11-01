package com.cpe.backend.repository;

import java.util.Collection;

import com.cpe.backend.entity.Menu;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface MenuRepository extends JpaRepository<Menu, Long> {

    Menu findById(long id);
    @Query(value = "SELECT * FROM MENU as m where m.maincourse_id = :m_id and m.restaurant_id = :r_id",nativeQuery = true)
    Collection<Menu> findMenuByResID(@Param("m_id") long m_id , @Param("r_id") long r_id );

    
    
}