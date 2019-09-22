package com.cpe.backend.repository;



import com.cpe.backend.entity.RawMaterial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface RawMaterialRepository extends JpaRepository<RawMaterial, Long> {

    RawMaterial findById(long id);
}