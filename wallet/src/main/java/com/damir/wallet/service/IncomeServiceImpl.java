/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;


import com.damir.wallet.dao.IncomeDAO;
import com.damir.wallet.model.Income;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codetech
 */
@Service("incomeService")
@Transactional
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeDAO dao;


    @Override
    public Income findDate(Date login_date) {
       return dao.findDate(login_date);
    }


    @Override
    public void saveIncome(Income income) {
         dao.saveIncome(income);
    }



    @Override
    public Double findByIncome4() {
       return dao.findByIncome4();
    }

    @Override
    public Double findByIncome1() {
      return dao.findByIncome1();
    }

    @Override
    public Double findByIncome2() {
       return dao.findByIncome2();
    }

    @Override
    public Double findByIncome3() {
        return dao.findByIncome3();
    }


    
    
}
