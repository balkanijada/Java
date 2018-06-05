/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.controller;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author codetech
 */
@XmlRootElement
public class ExpenseResponse {
    

      private double expense;
   
    
    
    public ExpenseResponse() {
        
    }

    public ExpenseResponse(double expense) {
        this.expense = expense;
     
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }
}
