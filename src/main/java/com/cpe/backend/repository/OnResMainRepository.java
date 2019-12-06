package com.cpe.backend.repository;

import com.cpe.backend.entity.OnResMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnResMainRepository extends JpaRepository<OnResMain, Long> {
    OnResMain findById(long id);
}
