/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Expense;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author codetech
 */

@Repository("expenseDAO")
public class ExpenseDAOImpl extends AbstractDAO implements ExpenseDAO{



    @Override
    public void saveExpense(Expense exp) {
        persist(exp);
    }



    @Override
    public void saveExpense(double expense) {
       persist(expense);
    }

    @Override
    public Expense findDate(Date login_date) {
                    Session session = getSession();

        List<Expense> user = session.createQuery("from Expense  where LOGIN_DATE= '" + login_date + "'").list();
        if (user.isEmpty()) {

            return null;
        }
        return user.get(0);
    
    }

    @Override
    public Double findByExpense1() {
         Session session = getSession();
       
      List<Double> sum = session.createQuery("select sum(expense) from Expense where login_date between (SYSDATE-1) and (SYSDATE+0)").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByExpense2() {
        Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(expense) from Expense where trunc(login_date, 'MON') = trunc(sysdate, 'MON')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByExpense3() {
     Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(expense) from Expense where  trunc(login_date, 'YEAR') = trunc(sysdate, 'Year')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByExpense4() {
        Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(expense) from Expense").list();
   
       return sum.get(0);
    }

   
}
