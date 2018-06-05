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
public class StudyResponse {
    
      private double study;

    public StudyResponse() {
    }

    public StudyResponse(double study) {
        this.study = study;
    }

    public double getStudy() {
        return study;
    }

    public void setStudy(double study) {
        this.study = study;
    }
    
}
