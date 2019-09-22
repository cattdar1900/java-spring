package com.cpe.backend.repository;



import com.cpe.backend.entity.OnOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface OnOptionRepository extends JpaRepository<OnOption, Long> {

    OnOption findById(long id);
}