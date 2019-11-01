package com.cpe.backend.repository;

import com.cpe.backend.entity.OnMatType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnMatTypeRepository extends JpaRepository<OnMatType, Long> {

    OnMatType findById(long id);
}
