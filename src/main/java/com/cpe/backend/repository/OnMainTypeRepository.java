package com.cpe.backend.repository;

import com.cpe.backend.entity.OnMainType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnMainTypeRepository extends JpaRepository<OnMainType, Long> {

    OnMainType findById(long id);
}
