/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;

import com.damir.wallet.model.Food;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author codetech
 */
public interface FoodService {
    Double findByFood1();

    Double findByFood2();

    Double findByFood3();

    Double findByFood4();

    void saveFood(Food food);

    Food findDate(Date login_date);
}
