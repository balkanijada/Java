/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Food;
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
@Repository("foodDAO")
public class FoodDAOImpl extends AbstractDAO implements FoodDAO{

    
    @Override
    public void saveFood(Food food) {
             persist(food);
    }

    @Override
    public Food findDate(Date login_date) {
          Session session = getSession();

        List<Food> user = session.createQuery("from Food  where LOGIN_DATE= '" + login_date + "'").list();
        if (user.isEmpty()) {

            return null;
        }
        return user.get(0);
    }

    @Override
    public Double findByFood1() {
          Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(food) from Food where login_date between (SYSDATE-1) and (SYSDATE+0)").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByFood2() {
              Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(food) from Food where trunc(login_date, 'MON') = trunc(sysdate, 'MON')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByFood3() {
           Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(food) from Food where trunc(login_date, 'YEAR') = trunc(sysdate, 'Year')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByFood4() {
          Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(food) from Food").list();
   
       return sum.get(0);
    }
    
    
}
