/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Income;
import com.damir.wallet.model.Transport;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author codetech
 */
public interface TransportDAO {

    Double findByTransport1();

    Double findByTransport2();

    Double findByTransport3();

    Double findByTransport4();

    void saveTransport(Transport transport);

    Transport findDate(Date login_date);
}
