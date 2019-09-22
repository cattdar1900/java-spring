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
@Table(name = "OnTypeFood")
public class OnTypeFood {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnTypeFood_seq",sequenceName="OnTypeFood_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnTypeFood_seq") 
  @Column(name = "OnTypeFood_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  
 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeFood.class)
  @JoinColumn(name = "TYPEFOOD_ID", insertable = true)
  private TypeFood typefood;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
  @JoinColumn(name = "RESTAURANT_ID", insertable = true)
  private Restaurant restaurant;

  //all-1 -> Option,Menu
  


  

}