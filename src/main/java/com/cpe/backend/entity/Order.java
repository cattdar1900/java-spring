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
import java.util.Date;
import java.util.Timer;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity  
@Data  
@NoArgsConstructor  
@Table(name = "Orders")
public class Order {  //สิทธิการรักษา
      
  @Id 
  @SequenceGenerator(name="Order_seq",sequenceName="Order_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Order_seq") 
  @Column(name = "Order_ID", unique = true, nullable = true)
  private @NonNull Long id;  
  @Getter @Setter
  private  String cusName ;  
  @Getter @Setter
  private String cusLocation ;
  @Getter @Setter 
  private String transDistance ;
  @Setter @Getter
  private String status;
  @Setter @Getter
  private Date date;


  //OnMenu 1 2 3

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Service.class)
  @JoinColumn(name = "SERVICE_ID", insertable = true)
  private Service service;

  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Rider.class)
  @JoinColumn(name = "RIDER_ID", insertable = true)
  private Rider rider;

  @OneToMany(fetch = FetchType.EAGER)
  //mappedBy  = "type"
  private Collection<OnOption> onOptions;


  

  


  //relation with order , link with food , link with raw material , link with menu
  


  

}