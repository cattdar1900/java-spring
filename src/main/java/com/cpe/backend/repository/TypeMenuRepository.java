package com.cpe.backend.repository;

import java.util.Collection;

import com.cpe.backend.Model.TypeMenuModel;
import com.cpe.backend.entity.TypeMenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;  
  
@RepositoryRestResource
public interface TypeMenuRepository extends JpaRepository<TypeMenu, Long> {

    TypeMenu findById(long id);
   @Query(value = "SELECT * FROM TYPE_MENU as tm inner join type_food as tf inner join on_main_type as omt on tm.typefood_id_TM = tf.type_foods_id_TF and tm.typefood_id_TM = omt.typefood_id where omt.maincourse_id = :id",nativeQuery = true)
   Collection<Object> findMenuByResIDs(@Param("id") long id );


    //@Query("select new com.cpe.backend.Model.TypeMenuModel * from TYPE_MENU as tm inner join type_food as tf inner join on_main_type as omt on tm.typefood_id_TM = tf.type_foods_id_TF and tm.typefood_id_TM = omt.typefood_id where omt.maincourse_id = :id")
   
    //@Query(value = "SELECT * FROM TYPE_MENU as tm inner join type_food as tf inner join on_main_type as omt on tm.typefood_id_TM = tf.type_foods_id_TF and tm.typefood_id_TM = omt.typefood_id where omt.maincourse_id = :id",nativeQuery = true)
    //SELECT * FROM TYPE_MENU as tm inner join type_food as tf inner join on_main_type as omt where tm.typefood_id = tf.type_foods_id and tm.typefood_id = omt.typefood_id
}