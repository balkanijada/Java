/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;


import com.damir.wallet.dao.FoodDAO;
import com.damir.wallet.model.Food;
import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codetech
 */
@Service("foodService")
@Transactional
public class FoodServiceImpl implements FoodService{
   @Autowired
    private FoodDAO dao;


    @Override
    public void saveFood(Food food) {
dao.saveFood(food);
    }

    @Override
    public Food findDate(Date login_date) {
return dao.findDate(login_date);
    }

    @Override
    public Double findByFood1() {
          return dao.findByFood1();
    }

    @Override
    public Double findByFood2() {
          return dao.findByFood2();
    }

    @Override
    public Double findByFood3() {
          return dao.findByFood3();
    }

    @Override
    public Double findByFood4() {
          return dao.findByFood4();
    }
    
}
