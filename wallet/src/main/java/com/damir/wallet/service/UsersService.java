/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;

import com.damir.wallet.model.Users;

/**
 *
 * @author codetech
 */
public interface UsersService {
    
      void saveUsers(Users users);
    boolean findUsers(Users users);

}
