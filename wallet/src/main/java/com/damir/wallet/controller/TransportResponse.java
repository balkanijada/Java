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
public class TransportResponse {

     private double transport;
   
    public TransportResponse() {
    }

    public TransportResponse(double transport) {
        this.transport = transport;
      
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

 

   
}