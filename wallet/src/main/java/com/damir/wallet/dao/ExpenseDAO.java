/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.dao;

import com.damir.wallet.model.Expense;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author codetech
 */
public interface ExpenseDAO {

    void saveExpense(double expense);

    Expense findDate(Date login_date);

    Double findByExpense1();

    Double findByExpense2();

    Double findByExpense3();

    Double findByExpense4();

    public void saveExpense(Expense exp);
}
