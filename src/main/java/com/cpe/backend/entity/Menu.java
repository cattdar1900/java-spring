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
@Table(name = "Menu")
public class Menu {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="MENU_seq",sequenceName="MENU_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="MENU_seq") 
  @Column(name = "MENU_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private String name ;  

  @Getter @Setter
  private int price ; 

  @Getter @Setter
  private boolean ex ;
  

  @Getter @Setter
  private int priceEx ; 
 

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnOption> onOption;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnMenu> onMenu;



  

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeMenu.class)
  @JoinColumn(name = "TYPEMENU_ID", insertable = true)
  private TypeMenu typemenu;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = MainCourse.class)
  @JoinColumn(name = "MAINCOURSE_ID", insertable = true)
  private MainCourse maincourse;

//  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeFood.class)
//  @JoinColumn(name = "TYPEFOOD_ID", insertable = true)
//  private TypeFood typefood;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
  @JoinColumn(name = "RESTAURANT_ID", insertable = true)
  private Restaurant restaurant;



  //1-all -> onOption , 1-all -> onMenu , 1-all -> typeMenu , 1-all mainCourse

  
  
  


  

}