/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Users;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 *
 * @author codetech
 */
@Repository("usersDao")
public class UsersDAOImpl extends AbstractDAO implements UsersDAO{

    @Override
    public void saveUsers(Users users) {
        persist(users);
    }

    @Override
    public boolean findUsers(Users users) {
            Session session = getSession();
        if(session.get(Users.class, users.getPassword()) != null){
            return true;
        }
        
        return false;
    }
    
}
