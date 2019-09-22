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
@Table(name = "Option")
public class Option {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="Option_seq",sequenceName="Option_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Option_seq") 
  @Column(name = "Option_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String name ;  
  @Getter @Setter
  private int price ;
  
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = MainCourse.class)
  @JoinColumn(name = "MAINCOURSE_ID", insertable = true)
  private MainCourse maincourse;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeFood.class)
  @JoinColumn(name = "TYPEFOOD_ID", insertable = true)
  private TypeFood typefood;


  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnOption> onoption;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Restaurant.class)
  @JoinColumn(name = "RESTAURANT_ID", insertable = true)
  private Restaurant restaurant;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnMainCourse> onMainCourse;

 
  


  //all-1 -> mainCourse , all-1 -> TypeFood , all-1 -> market
  //1-all -> onOption
  


  

}