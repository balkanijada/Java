/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Income;
import java.sql.Date;
import java.sql.Timestamp;
import org.hibernate.Query;

/**
 *
 * @author codetech
 */
public interface IncomeDAO {

    Double findByIncome1();

    Double findByIncome2();

    Double findByIncome3();

    Double findByIncome4();

    Income findDate(Date login_date);

    void saveIncome(Income income);
    
     

}
