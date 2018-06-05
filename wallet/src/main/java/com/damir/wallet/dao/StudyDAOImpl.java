/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Study;
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
@Repository("studyDAO")
public class StudyDAOImpl extends AbstractDAO  implements StudyDAO{


    

    @Override
    public void saveStudy(Study study) {
        persist(study);
    }

    @Override
    public Study findDate(Date login_date) {
         Session session = getSession();

        List<Study> user = session.createQuery("from Study  where LOGIN_DATE= '" + login_date + "'").list();
        if (user.isEmpty()) {

            return null;
        }
        return user.get(0);
    }

    @Override
    public Double findByStudy1() {
    Session session = getSession();
       
      List<Double> sum = session.createQuery("select sum(study) from Study where login_date between (SYSDATE-1) and (SYSDATE+0)").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByStudy2() {
       Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(study) from Study where trunc(login_date, 'MON') = trunc(sysdate, 'MON')").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByStudy3() {
        Session session = getSession();
       
     List<Double> sum = session.createQuery("select sum(study) from Study where  trunc(login_date, 'YEAR') = trunc(sysdate, 'Year') ").list();
   
       return sum.get(0);
    }

    @Override
    public Double findByStudy4() {
          Session session = getSession();
       
   List<Double> sum = session.createQuery("select sum(study) from Study").list();
   
       return sum.get(0);
    }
    
    
}
