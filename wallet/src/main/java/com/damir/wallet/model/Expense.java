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
@Table(name="EXPENSE")
@XmlRootElement
public class Expense implements Serializable {
    
    @Id
    private double expense;
   
    private Date login_date;

    public Expense() {
    }

    public Expense(double expense, Date login_date) {
        this.expense = expense;
        this.login_date = login_date;
    }

    public double getExpense() {
        return expense;
    }

    public void setExpense(double expense) {
        this.expense = expense;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

   

}