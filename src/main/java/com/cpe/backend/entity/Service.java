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
@Table(name = "Service")
public class Service {  //สิทธิการรักษา
      
  @Id 
  @Column(name = "Service_ID", unique = true, nullable = true)
  private @NonNull String id;
  private  String name ;
  private String username ;
  private String password ;

//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<Order> order;


  //relation with order , can edit order , view order , CRUD order


  

}