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
@Table(name = "OnMatType")
public class OnMatType {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnMatType_seq",sequenceName="OnMatType_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnMatType_seq") 
  @Column(name = "OnMatType_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  
 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = RawMaterial.class)
  @JoinColumn(name = "RawMaterial_ID", insertable = true)
  private RawMaterial rawMaterial;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeFood.class)
  @JoinColumn(name = "TypeFood_ID", insertable = true)
  private TypeFood typeFood;

  //all-1 -> RawMaterial,TypeFood
  


  

}