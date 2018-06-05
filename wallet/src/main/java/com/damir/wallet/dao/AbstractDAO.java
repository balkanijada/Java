/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author codetech
 */
public abstract class AbstractDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public void persist(Object entity) {
        getSession().persist(entity);
    }
    
    public void delete(Object entity) {
        getSession().delete(entity);
    }
}
