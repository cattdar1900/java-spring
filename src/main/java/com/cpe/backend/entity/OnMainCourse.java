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
@Table(name = "OnMainCourse")
public class OnMainCourse {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnMainCourse_seq",sequenceName="OnMainCourse_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnMainCourse_seq") 
  @Column(name = "OnMainCourse_ID", unique = true, nullable = true)
  private @NonNull Long id;
  private  String nameM ;  
 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = MainCourse.class)
  @JoinColumn(name = "MAINCOURSE_ID", insertable = true)
  private MainCourse maincourse;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Option.class)
  @JoinColumn(name = "OPTION_ID", insertable = true)
  private Option option;

  //all-1 -> Option,Menu
  


  

}