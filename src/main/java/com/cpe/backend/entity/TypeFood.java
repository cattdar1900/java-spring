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
@Table(name = "typeFood")
public class TypeFood {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="typeFood_seq",sequenceName="typeFood_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="typeFood_seq") 
  @Column(name = "typeFood_ID", unique = true, nullable = true)
  private @NonNull Long id;
  private  String name ;  
  


  //one to many -> mainCourse , one to many -> typeMenu , one to many -> Menu 
  //one to many -> option , one to many -> rawMaterial 

//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<OnMainType> onmaintype;
//
//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<Option> option;
//
//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<TypeMenu> typemenu;

//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<Menu> menu;

//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<OnMatType> onMatType;
//
//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<OnTypeFood> ontypefood;



  
  
  
  
  
  


  

}