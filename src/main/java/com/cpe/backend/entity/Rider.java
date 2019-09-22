package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;


import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity  
@Data  
@NoArgsConstructor  
@Table(name = "Rider")
public class Rider {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="RIDER_SEQ",sequenceName="RIDER_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RIDER_SEQ") 
  @Column(name = "Rider_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  
  @Getter @Setter
  private String username ;
  @Getter @Setter 
  private String password ;
  @Getter @Setter 
  private int income ;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<Order> order;


  //relation with order


  

}