/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;

import com.damir.wallet.dao.HealthDAO;
import com.damir.wallet.model.Health;
import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codetech
 */
@Service("healthService")
@Transactional
public class HealthServiceImpl implements HealthService{
   @Autowired
    private HealthDAO dao;


    @Override
    public void saveHealth(Health health) {
     dao.saveHealth(health);
    }

    @Override
    public Health findDate(Date login_date) {
 return dao.findDate(login_date);
    }

    @Override
    public Double findByHealth1() {
        return dao.findByHealth1();
    }

    @Override
    public Double findByHealth2() {
         return dao.findByHealth2();
    }

    @Override
    public Double findByHealth3() {
         return dao.findByHealth3();
    }

    @Override
    public Double findByHealth4() {
         return dao.findByHealth4();
    }
    
}
