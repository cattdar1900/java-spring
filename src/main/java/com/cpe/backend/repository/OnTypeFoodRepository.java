package com.cpe.backend.repository;

import com.cpe.backend.entity.OnTypeFood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OnTypeFoodRepository extends JpaRepository<OnTypeFood, Long> {

    OnTypeFood findById(long id);
    
    @Query(value = "SELECT * FROM ON_TYPE_FOOD where ResTAURANT_ID =", nativeQuery  =true)
    OnTypeFood findTypeFoodByResID(@Param("id") long id);
    //SELECT * FROM ON_TYPE_FOOD where ResTAURANT_ID =
}
