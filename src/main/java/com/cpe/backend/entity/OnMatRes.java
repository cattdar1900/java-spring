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
@Table(name = "OnMatRes")
public class OnMatRes {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnMatRes_seq",sequenceName="OnMatRes_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnMatRes_seq") 
  @Column(name = "OnMatRess_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  
 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
  @JoinColumn(name = "Restaurants_ID", insertable = true)
  private Restaurant restaurant;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = RawMaterial.class)
  @JoinColumn(name = "RawMaterials_ID", insertable = true)
  private RawMaterial rawMaterial;

  //all-1 -> Restaurant,RawMaterial
  


  

}