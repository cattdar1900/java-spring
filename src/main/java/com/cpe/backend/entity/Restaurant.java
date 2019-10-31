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
@Table(name = "Restaurant")
public class Restaurant {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="Restaurant_seq",sequenceName="Restaurant_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Restaurant_seq") 
  @Column(name = "Restaurant_ID", unique = true, nullable = true)
  private @NonNull Long id;
  private  String name ;
  private String username ;
  private String password ;
  private int income ;
  private String La_location ;
  private String Lo_location ;


  //1-1 with everything 

//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<Menu> menu;
//
//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<OnResMain> onresmain;
//
//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<OnTypeFood> ontypefood;
//
//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<Option> option;
//
//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<OnMatRes> onMatres;

//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<TypeMenu> typemenu;

  


  


  

}