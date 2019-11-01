package com.cpe.backend.repository;

import com.cpe.backend.entity.OnMatRes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnMatResRepository extends JpaRepository<OnMatRes, Long> {

    OnMatRes findById(long id);
}
