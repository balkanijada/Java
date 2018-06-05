/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class IncomeResponse {

      private double income;
   
    
    
    public IncomeResponse() {
        
    }

    public IncomeResponse(double income) {
        this.income = income;
     
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }




  


    
}

