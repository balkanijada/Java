/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;

import com.damir.wallet.dao.AbstractDAO;
import com.damir.wallet.dao.UsersDAO;
import com.damir.wallet.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codetech
 */

@Service("usersService")
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersDAO dao;
    
    @Override
    public void saveUsers(Users users) {
        dao.saveUsers(users);
    }

    @Override
    public boolean findUsers(Users users) {
           return dao.findUsers(users);
    }
    
}
