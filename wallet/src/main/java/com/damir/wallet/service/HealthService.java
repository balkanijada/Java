/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;

import com.damir.wallet.model.Food;
import com.damir.wallet.model.Health;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author codetech
 */
public interface HealthService {
    Double findByHealth1();

    Double findByHealth2();

    Double findByHealth3();

    Double findByHealth4();

    void saveHealth(Health health);

    Health findDate(Date login_date);
}
