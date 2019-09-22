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
@Table(name = "OnResMain")
public class OnResMain {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnResMain_seq",sequenceName="OnResMain_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnResMain_seq") 
  @Column(name = "OnResMain_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  
 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
  @JoinColumn(name = "Restaurant_ID", insertable = true)
  private Restaurant restaurant;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = MainCourse.class)
  @JoinColumn(name = "MainCourse_ID", insertable = true)
  private MainCourse mainCourse;

  //all-1 -> Restaurant,MainCourse
  


  

}