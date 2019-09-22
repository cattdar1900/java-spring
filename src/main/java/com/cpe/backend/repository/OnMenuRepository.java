package com.cpe.backend.repository;



import com.cpe.backend.entity.OnMenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface OnMenuRepository extends JpaRepository<OnMenu, Long> {

    OnMenu findById(long id);
}