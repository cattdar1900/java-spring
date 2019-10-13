package com.cpe.backend.repository;

import java.util.Collection;

import com.cpe.backend.entity.MainCourse;
import com.cpe.backend.entity.OnMainCourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OnMainCourseRepository extends JpaRepository<OnMainCourse, Long> {

    OnMainCourse findById(long id);
    @Query(value = "select m.main_course_id , m.name from main_course as m " +
    "inner join on_res_main as o " +
   " on m.main_course_id = o.main_course_id " +
    " where o.restaurant_id = 1" , nativeQuery  =true)
    Collection<MainCourse> findMainCourseByMarket(@Param("id") long id);

}