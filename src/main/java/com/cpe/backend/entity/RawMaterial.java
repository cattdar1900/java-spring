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
@Table(name = "RawMaterial")
public class RawMaterial {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="RawMaterial_seq",sequenceName="RawMaterial_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="RawMaterial_seq") 
  @Column(name = "RawMaterial_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  



  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnMenu> onMenu;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnMatRes> onMatRes;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnMatType> onMatTypes;

  

  //all-1 -> typeFood , Market
  //1-all -> onMenu 
  


  

}