/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Transport;
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
@Repository("transportDAO")
public class TransportDAOImpl extends AbstractDAO implements TransportDAO{


    

    @Override
    public void saveTransport(Transport transport) {
       persist(transport);
    }

    @Override
    public Transport findDate(Date login_date) {
          Session session = getSession();

        List<Transport> user = session.createQuery("from Transport  where LOGIN_DATE= '" + login_date + "'").list();
        if (user.isEmpty()) {

            return null;
        }
        return user.get(0);
    }

    @Override
    public Double findByTransport1() {
             Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(transport) from Transport where login_date between (SYSDATE-1) and (SYSDATE+0)").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByTransport2() {
           Session session = getSession();
       
    List<Double> sum = session.createQuery("select sum(transport) from Transport  where trunc(login_date, 'MON') = trunc(sysdate, 'MON')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByTransport3() {
           Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(transport) from Transport where trunc(login_date, 'YEAR') = trunc(sysdate, 'Year')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByTransport4() {
           Session session = getSession();
       
    List<Double> sum = session.createQuery("select sum(transport) from Transport").list();
   
       return sum.get(0);
    }
    
}
