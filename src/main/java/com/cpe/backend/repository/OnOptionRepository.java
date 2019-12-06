package com.cpe.backend.repository;



import com.cpe.backend.entity.OnOption;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface OnOptionRepository extends JpaRepository<OnOption, Long> {

    OnOption findById(long id);

    @Query(value = "SELECT * FROM ON_OPTION WHERE ORDER_ID = :id",nativeQuery = true)
    Collection<OnOption> findOnOptionByOrderId(@Param("id") long id);
}