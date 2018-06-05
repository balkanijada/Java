/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.controller;

/**
 *
 * @author codetech
 */
public class IncomeRequest {
    
    private double income;

    public IncomeRequest() {
    }

    public IncomeRequest(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }


    
}
