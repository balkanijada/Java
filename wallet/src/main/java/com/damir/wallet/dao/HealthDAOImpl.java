/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Health;
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
@Repository("healthDAO")
public class HealthDAOImpl extends AbstractDAO implements HealthDAO{

    

    @Override
    public void saveHealth(Health health) {
          persist(health);
    }

    @Override
    public Health findDate(Date login_date) {
     Session session = getSession();

        List<Health> user = session.createQuery("from Health  where LOGIN_DATE= '" + login_date + "'").list();
        if (user.isEmpty()) {

            return null;
        }
        return user.get(0);
    }

    @Override
    public Double findByHealth1() {
         Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(health) from Health where login_date between (SYSDATE-1) and (SYSDATE+0)").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByHealth2() {
            Session session = getSession();
       
        List<Double> sum = session.createQuery("select sum(health) from Health where trunc(login_date, 'MON') = trunc(sysdate, 'MON')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByHealth3() {
        Session session = getSession();
       
       List<Double> sum = session.createQuery("select sum(health) from Health where  trunc(login_date, 'YEAR') = trunc(sysdate, 'Year') ").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByHealth4() {
            Session session = getSession();
       
       List<Double> sum = session.createQuery("select sum(health) from Health").list();
   
       return sum.get(0);
    }
    }


