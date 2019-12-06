package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;


import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity  
@Data  
@NoArgsConstructor  
@Table(name = "OnMenu")
public class OnMenu {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnMenu_seq",sequenceName="OnMenu_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnMenu_seq") 
  @Column(name = "OnMenu_ID", unique = true, nullable = true)
  private @NonNull Long id;
  private  String name ;  
  
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Menu.class)
  @JoinColumn(name = "typeMenu_MENU_ID", insertable = true)
  private TypeMenu typeMenumenu;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = RawMaterial.class)
  @JoinColumn(name = "RAWMATERIAL_ID", insertable = true)
  private RawMaterial rawmaterial;

  //all-1 -> Menu,RawMaterial




  
  


  

}