package com.cpe.backend.entity;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;


import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity  
@Data  
@NoArgsConstructor  
@Table(name = "OnOption")
public class OnOption {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="OnOption_seq",sequenceName="OnOption_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OnOption_seq") 
  @Column(name = "OnOption_ID", unique = true, nullable = true)
  private @NonNull Long id;
  private  String name ;
  private int amountOption ;
  private int totalPriceOp;
  private int amountMenu ;
  private int totalPriceMenu;
  private int totalPrice;

 
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Option.class)
  @JoinColumn(name = "OPTION_ID", insertable = true)
  private Option option;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Menu.class)
  @JoinColumn(name = "MENU_ID", insertable = true)
  private Menu menu;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Order.class)
  @JoinColumn(name = "ORDER_ID", insertable = true)
  private Order order;

  //all-1 -> Option,Menu
  


  

}