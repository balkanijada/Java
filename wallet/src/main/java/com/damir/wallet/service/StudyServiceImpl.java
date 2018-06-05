/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.service;


import com.damir.wallet.dao.StudyDAO;
import com.damir.wallet.model.Study;
import java.sql.Date;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author codetech
 */
@Service("studyService")
@Transactional
public class StudyServiceImpl implements StudyService{
   @Autowired
    private StudyDAO dao;
 

    @Override
    public void saveStudy(Study study) {
      dao.saveStudy(study);
    }

    @Override
    public Study findDate(Date login_date) {
        return dao.findDate(login_date);
    }

    @Override
    public Double findByStudy1() {
         return dao.findByStudy1();
    }

    @Override
    public Double findByStudy2() {
       return dao.findByStudy2();
    }

    @Override
    public Double findByStudy3() {
       return dao.findByStudy3();
    }

    @Override
    public Double findByStudy4() {
        return dao.findByStudy4();
    }
    
}
