/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;

import com.damir.wallet.model.Food;
import com.damir.wallet.model.Study;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author codetech
 */
public interface StudyService {
   Double findByStudy1();

    Double findByStudy2();

    Double findByStudy3();

    Double findByStudy4();

    void saveStudy(Study study);

    Study findDate(Date login_date);
}

