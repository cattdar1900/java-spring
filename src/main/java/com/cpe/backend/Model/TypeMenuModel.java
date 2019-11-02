  
package com.cpe.backend.Model;
import lombok.*;



@Data
public  class TypeMenuModel {
    private long TYPE_MENU_ID;
    private String NAMET;
    private long TYPEFOOD_ID_TM;
    private long ON_MAIN_TYPE_ID;
    private String NAMEMT;
    private long MAINCOURSE_ID;
    private long TYPEFOOD_ID ;
    private long TYPE_FOODS_ID_TF;
    private String NAMETF  ;    
}