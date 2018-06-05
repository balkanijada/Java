/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.controller.WalletController;
import com.damir.wallet.model.Income;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author codetech
 */
@Repository("incomeDAO")
public class IncomeDAOImpl extends AbstractDAO implements IncomeDAO {
 private static final Logger logger = Logger.getLogger(IncomeDAOImpl.class);
 

    @Override
    public void saveIncome(Income income) {
        persist(income);
    }

    @Override
    public Income findDate(Date login_date) {
        Session session = getSession();

        List<Income> user = session.createQuery("from Income  where LOGIN_DATE= '" + login_date + "'").list();

        return user.get(0);
    }
    
   @Override
    public Double findByIncome1() {
         Session session = getSession();
       
      List<Double> sum = session.createQuery("select sum(income) from Income where login_date between (SYSDATE-1) and (SYSDATE+0)").list();
   
       return sum.get(0);
    }
    @Override
    public Double findByIncome2() {
      Session session = getSession();
       
      List<Double> sum = session.createQuery("select sum(income) from Income where trunc(login_date, 'MON') = trunc(sysdate, 'MON')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByIncome3() {
        Session session = getSession();
       
      List<Double> sum = session.createQuery("select sum(income) from Income where trunc(login_date, 'YEAR') = trunc(sysdate, 'Year')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByIncome4() {
        Session session = getSession();
       
      List<Double> sum = session.createQuery("select sum(income) from Income").list();
   
       return sum.get(0);
      
    }
}
