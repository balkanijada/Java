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
@Table(name="FOOD")
@XmlRootElement
public class Food implements Serializable {
    
    @Id
    private double food;
   
    private Date login_date;

    public Food() {
    }

    public Food(double food, Date login_date) {
        this.food = food;
        this.login_date = login_date;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }
    
}
