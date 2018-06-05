/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;



import com.damir.wallet.dao.ExpenseDAO;
import com.damir.wallet.model.Expense;
import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codetech
 */

@Service("expenseService")
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseDAO dao;


    @Override
    public Expense findDate(Date login_date) {
       return dao.findDate(login_date);
    }

    @Override
    public void saveExpense(Expense exp) {
       dao.saveExpense(exp);
    }

    @Override
    public Double findByExpense1() {
       return dao.findByExpense1();
    }

    @Override
    public Double findByExpense2() {
          return dao.findByExpense2();
    }

    @Override
    public Double findByExpense3() {
          return dao.findByExpense3();
    }

    @Override
    public Double findByExpense4() {
   return dao.findByExpense4();
    }

    

    

    
}
