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
@Table(name="TRANSPORT")
@XmlRootElement
public class Transport implements Serializable {
    
    @Id
    private double transport;
   
    private Date login_date;

    public Transport() {
    }

    public Transport(double trasnport, Date login_date) {
        this.transport = transport;
        this.login_date = login_date;
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }


    
}
