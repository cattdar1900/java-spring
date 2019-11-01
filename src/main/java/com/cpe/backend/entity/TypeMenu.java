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
@Table(name = "TypeMenu")
public class TypeMenu {
      
  @Id 
  @SequenceGenerator(name="TypeMenu_seq",sequenceName="TypeMenu_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TypeMenu_seq") 
  @Column(name = "TypeMenu_ID", unique = true, nullable = true)
  private @NonNull Long id;
  private  String nameT ;  

//  @OneToMany(fetch = FetchType.EAGER)
//  //mappedBy  = "type"
//  private Collection<Menu> menu;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeFood.class)
  @JoinColumn(name = "TYPEFOOD_ID_TM", insertable = true)
  private TypeFood typefood;

//  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
//  @JoinColumn(name = "RESTAURANT_ID", insertable = true)
//  private Restaurant restaurant;

  
 


  //all-1  -> typeMenu , all-1 -> market , all-1 -> Menu


  


  

}