/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.controller;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @author codetech
 */
public class BalanceResponse {
    
    private double balance;
   
       
    public BalanceResponse() {
    }

    public BalanceResponse(double balance) {
        this.balance = balance;
      
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

  
  
    
    
}
