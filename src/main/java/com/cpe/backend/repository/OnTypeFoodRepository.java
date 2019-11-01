package com.cpe.backend.repository;

import com.cpe.backend.entity.OnTypeFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnTypeFoodRepository extends JpaRepository<OnTypeFood, Long> {

    OnTypeFood findById(long id);
}
