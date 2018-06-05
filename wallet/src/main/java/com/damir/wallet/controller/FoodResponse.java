/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author codetech
 */
@XmlRootElement
public class FoodResponse {
    
         private double food;
  
     
       
    public FoodResponse() {
    }

    public FoodResponse(double food ){
        this.food = food;
  
      
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

  

    
    
}
