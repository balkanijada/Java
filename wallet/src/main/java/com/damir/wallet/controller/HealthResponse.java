/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.controller;

import java.sql.Timestamp;

/**
 *
 * @author codetech
 */
public class HealthResponse {
     private double health;

    public HealthResponse() {
    }

    public HealthResponse(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }
   
}
