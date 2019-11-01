package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;


import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity  
@Data  
@NoArgsConstructor  
@Table(name = "OnMainType")
public class OnMainType {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnMainType_seq",sequenceName="OnMainType_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnMainType_seq") 
  @Column(name = "OnMainType_ID", unique = true, nullable = true)
  private @NonNull Long id;
  private  String nameMT ;  
 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = MainCourse.class)
  @JoinColumn(name = "MAINCOURSE_ID", insertable = true)
  private MainCourse maincourse;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeFood.class)
  @JoinColumn(name = "TYPEFOOD_ID", insertable = true)
  private TypeFood typefood;

  //all-1 -> Option,Menu
  


  

}