package com.cpe.backend.repository;



import com.cpe.backend.entity.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface OptionRepository extends JpaRepository<Option, Long> {

    Option findById(long id);
}