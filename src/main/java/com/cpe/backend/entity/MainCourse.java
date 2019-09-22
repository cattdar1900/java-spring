package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MainCourse")
public class MainCourse {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="MainCourse_seq",sequenceName="MainCourset_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MainCourse_seq") 
  @Column(name = "MainCourse_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  



  //all-1 -> TypeFood , Menu , Market 
  //1-all ->Option


  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<Menu> menu;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnResMain> onResMains;


  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnMainCourse> onmaincourse;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnMainType> onmaintype;
  


  

}