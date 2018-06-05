/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.model;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author codetech
 */
@Entity
@Table(name="STUDY")
@XmlRootElement
public class Study implements Serializable {
    
    @Id
    private double study;
   
    private Date login_date;

    public Study() {
    }

    public Study(double study, Date login_date) {
        this.study = study;
        this.login_date = login_date;
    }

    public double getStudy() {
        return study;
    }

    public void setStudy(double study) {
        this.study = study;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }
    
}
