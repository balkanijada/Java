/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;

import com.damir.wallet.dao.TransportDAO;
import com.damir.wallet.model.Transport;
import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codetech
 */
@Service("transportService")
@Transactional
public class TransportServiceImpl implements TransportService{
   @Autowired
    private TransportDAO dao;
  

    @Override
    public void saveTransport(Transport transport) {
        dao.saveTransport(transport);
    }

    @Override
    public Transport findDate(Date login_date) {
  return dao.findDate(login_date);
    }

    @Override
    public Double findByTransport1() {
         return dao.findByTransport1();
    }

    @Override
    public Double findByTransport2() {
        return dao.findByTransport2();
    }

    @Override
    public Double findByTransport3() {
        return dao.findByTransport3();
    }

    @Override
    public Double findByTransport4() {
        return dao.findByTransport4();
    }
    
}
