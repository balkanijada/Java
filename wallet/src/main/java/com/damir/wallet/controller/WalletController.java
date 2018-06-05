/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.controller;

import com.damir.wallet.model.Expense;
import com.damir.wallet.model.Food;
import com.damir.wallet.model.Health;
import com.damir.wallet.model.Income;
import com.damir.wallet.model.Study;
import com.damir.wallet.model.Transport;
import com.damir.wallet.service.ExpenseService;
import com.damir.wallet.service.FoodService;
import com.damir.wallet.service.HealthService;
import com.damir.wallet.service.IncomeService;
import com.damir.wallet.service.StudyService;
import com.damir.wallet.service.TransportService;
import java.sql.Date;
import java.sql.Timestamp;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author codetech
 */
@RestController
public class WalletController {

    private static final Logger logger = Logger.getLogger(WalletController.class);

    @Autowired
    private static SessionFactory sessionFactory;

    @RequestMapping(value = "/postincome", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    IncomeResponse getIncome(@RequestBody IncomeRequest requestBody) {

        logger.info("Inside getAuthToken method");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        IncomeResponse response = new IncomeResponse();

        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        Income inc = new Income();

        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        inc.setIncome(requestBody.getIncome());  //upis u tabelu u bazi
        inc.setLogin_date(createdTimestamp);

        incomeService.saveIncome(inc);

        response.setIncome(requestBody.getIncome());  //response u postman

        return response;
    }

    @RequestMapping(value = "/postfood", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    FoodResponse getFood(@RequestBody FoodRequest requestBody) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        FoodResponse response = new FoodResponse();

        FoodService foodService = (FoodService) context.getBean("foodService");

        Food foo = new Food();

        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        foo.setFood(requestBody.getFood());  //upis u tabelu u bazi

        foo.setLogin_date(createdTimestamp);
        foodService.saveFood(foo);

        response.setFood(requestBody.getFood());//response u postman

        return response;
    }

    @RequestMapping(value = "/posthealth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    HealthResponse getHealth(@RequestBody HealthRequest requestBody) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        HealthResponse response = new HealthResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        HealthService healthService = (HealthService) context.getBean("healthService");

        Health hea = new Health();

        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        hea.setHealth(requestBody.getHealth());  //upis u tabelu u bazi

        hea.setLogin_date(createdTimestamp);
        healthService.saveHealth(hea);

        response.setHealth(requestBody.getHealth());//response u postman

        return response;
    }

    @RequestMapping(value = "/poststudy", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    StudyResponse getStudy(@RequestBody StudyRequest requestBody) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        StudyResponse response = new StudyResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        StudyService studyService = (StudyService) context.getBean("studyService");

        Study stu = new Study();

        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        stu.setStudy(requestBody.getStudy());  //upis u tabelu u bazi

        stu.setLogin_date(createdTimestamp);
        studyService.saveStudy(stu);

        response.setStudy(requestBody.getStudy());//response u postman

        return response;
    }

    @RequestMapping(value = "/posttransport", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    TransportResponse getTransport(@RequestBody TransportRequest requestBody) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        TransportResponse response = new TransportResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        TransportService transportService = (TransportService) context.getBean("transportService");

        Transport tran = new Transport();

        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        tran.setTransport(requestBody.getTransport());  //upis u tabelu u bazi

        tran.setLogin_date(createdTimestamp);
        transportService.saveTransport(tran);

        response.setTransport(requestBody.getTransport());//response u postman

        return response;
    }

    @RequestMapping(value = "/getincome1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public IncomeResponse response1() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        IncomeResponse response = new IncomeResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");

        if (incomeService.findByIncome1() == null) {
            response.setIncome(0);
            return response;
        }
        response.setIncome(incomeService.findByIncome1());

        return response;

    }

    @RequestMapping(value = "/getincome2", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public IncomeResponse response2() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        IncomeResponse response = new IncomeResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        if (incomeService.findByIncome2() == null) {
            response.setIncome(0);
            return response;
        }
        response.setIncome(incomeService.findByIncome2());

        return response;

    }

    @RequestMapping(value = "/getincome3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public IncomeResponse response3() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        IncomeResponse response = new IncomeResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        if (incomeService.findByIncome3() == null) {
            response.setIncome(0);
            return response;
        }
        response.setIncome(incomeService.findByIncome3());

        return response;

    }

    @RequestMapping(value = "/getincome4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public @ResponseBody
    IncomeResponse response4() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        IncomeResponse response = new IncomeResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        if (incomeService.findByIncome4() == null) {
            response.setIncome(0);
            return response;
        }
        response.setIncome(incomeService.findByIncome4());

        return response;

    }

    @RequestMapping(value = "/getexpense1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ExpenseResponse response5() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        Expense expense = new Expense();
        ExpenseResponse response = new ExpenseResponse();
        ExpenseService expenseService = (ExpenseService) context.getBean("expenseService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        TransportService transportService = (TransportService) context.getBean("transportService");
        
        if(foodService.findByFood1() == null && healthService.findByHealth1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null){
             response.setExpense(0);
            return response;
        }else if (foodService.findByFood1() == null && healthService.findByHealth1() == null && studyService.findByStudy1() == null) {
            response.setExpense(transportService.findByTransport1());
            return response;
        } else if (foodService.findByFood1() == null && healthService.findByHealth1() == null && transportService.findByTransport1() == null) {
            response.setExpense(studyService.findByStudy1());
            return response;
        } else if (foodService.findByFood1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null) {
            response.setExpense(healthService.findByHealth1());
            return response;
        } else if (healthService.findByHealth1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null) {
            response.setExpense(foodService.findByFood1());
            return response;
        } else if (foodService.findByFood1() == null && healthService.findByHealth1() == null) {
            response.setExpense(studyService.findByStudy1() + transportService.findByTransport1());
            return response;
        } else if (foodService.findByFood1() == null && studyService.findByStudy1() == null) {
            response.setExpense(healthService.findByHealth1() + transportService.findByTransport1());
            return response;
        } else if (foodService.findByFood1() == null && transportService.findByTransport1() == null) {
            response.setExpense(healthService.findByHealth1() + studyService.findByStudy1());
            return response;
        } else if (healthService.findByHealth1() == null && studyService.findByStudy1() == null) {
            response.setExpense(foodService.findByFood1() + transportService.findByTransport1());
            return response;
        } else if (healthService.findByHealth1() == null && transportService.findByTransport1() == null) {
            response.setExpense(foodService.findByFood1() + studyService.findByStudy1());
            return response;
        } else if (studyService.findByStudy1() == null && transportService.findByTransport1() == null) {
            response.setExpense(foodService.findByFood1() + healthService.findByHealth1());
            return response;
        } else if (foodService.findByFood1() == null) {
            response.setExpense(healthService.findByHealth1() + studyService.findByStudy1() + transportService.findByTransport1());
            return response;
        } else if (healthService.findByHealth1() == null) {
            response.setExpense(foodService.findByFood1() + studyService.findByStudy1() + transportService.findByTransport1());
            return response;
        } else if (studyService.findByStudy1() == null) {
            response.setExpense(healthService.findByHealth1() + foodService.findByFood1() + transportService.findByTransport1());
            return response;
        } else if (transportService.findByTransport1() == null) {
            response.setExpense(healthService.findByHealth1() + studyService.findByStudy1() + foodService.findByFood1());
            return response;
        }
        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        expense.setLogin_date(createdTimestamp);
        expense.setExpense(foodService.findByFood1() + healthService.findByHealth1() + studyService.findByStudy1() + transportService.findByTransport1());
        expenseService.saveExpense(expense);
        response.setExpense(foodService.findByFood1() + healthService.findByHealth1() + studyService.findByStudy1() + transportService.findByTransport1());

        return response;
    }
    @RequestMapping(value = "/getexpense2", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ExpenseResponse response6() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        Expense expense = new Expense();
        ExpenseResponse response = new ExpenseResponse();
        ExpenseService expenseService = (ExpenseService) context.getBean("expenseService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        TransportService transportService = (TransportService) context.getBean("transportService");
          if(foodService.findByFood2() == null && healthService.findByHealth2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null){
             response.setExpense(0);
            return response;
        }else if (foodService.findByFood2() == null && healthService.findByHealth2() == null && studyService.findByStudy2() == null) {
            response.setExpense(transportService.findByTransport2());
            return response;
        } else if (foodService.findByFood2() == null && healthService.findByHealth2() == null && transportService.findByTransport2() == null) {
            response.setExpense(studyService.findByStudy2());
            return response;
        } else if (foodService.findByFood2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null) {
            response.setExpense(healthService.findByHealth2());
            return response;
        } else if (healthService.findByHealth2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null) {
            response.setExpense(foodService.findByFood2());
            return response;
        } else if (foodService.findByFood2() == null && healthService.findByHealth2() == null) {
            response.setExpense(studyService.findByStudy2() + transportService.findByTransport2());
            return response;
        } else if (foodService.findByFood2() == null && studyService.findByStudy2() == null) {
            response.setExpense(healthService.findByHealth2() + transportService.findByTransport2());
            return response;
        } else if (foodService.findByFood2() == null && transportService.findByTransport2() == null) {
            response.setExpense(healthService.findByHealth2() + studyService.findByStudy2());
            return response;
        } else if (healthService.findByHealth2() == null && studyService.findByStudy2() == null) {
            response.setExpense(foodService.findByFood2() + transportService.findByTransport2());
            return response;
        } else if (healthService.findByHealth2() == null && transportService.findByTransport2() == null) {
            response.setExpense(foodService.findByFood2() + studyService.findByStudy2());
            return response;
        } else if (studyService.findByStudy2() == null && transportService.findByTransport2() == null) {
            response.setExpense(foodService.findByFood2() + healthService.findByHealth2());
            return response;
        } else if (foodService.findByFood2() == null) {
            response.setExpense(healthService.findByHealth2() + studyService.findByStudy2() + transportService.findByTransport2());
            return response;
        } else if (healthService.findByHealth2() == null) {
            response.setExpense(foodService.findByFood2() + studyService.findByStudy2() + transportService.findByTransport2());
            return response;
        } else if (studyService.findByStudy2() == null) {
            response.setExpense(healthService.findByHealth2() + foodService.findByFood2() + transportService.findByTransport2());
            return response;
        } else if (transportService.findByTransport2() == null) {
            response.setExpense(healthService.findByHealth2() + studyService.findByStudy2() + foodService.findByFood2());
            return response;
        }
        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        expense.setLogin_date(createdTimestamp);
        expense.setExpense(foodService.findByFood2() + healthService.findByHealth2() + studyService.findByStudy2() + transportService.findByTransport2());
        expenseService.saveExpense(expense);
        response.setExpense(foodService.findByFood2() + healthService.findByHealth2() + studyService.findByStudy2() + transportService.findByTransport2());

        return response;
    }

    @RequestMapping(value = "/getexpense3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ExpenseResponse response7() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        Expense expense = new Expense();
        ExpenseResponse response = new ExpenseResponse();
        ExpenseService expenseService = (ExpenseService) context.getBean("expenseService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        TransportService transportService = (TransportService) context.getBean("transportService");
           if(foodService.findByFood3() == null && healthService.findByHealth3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null){
             response.setExpense(0);
            return response;
        }else if (foodService.findByFood3() == null && healthService.findByHealth3() == null && studyService.findByStudy3() == null) {
            response.setExpense(transportService.findByTransport3());
            return response;
        } else if (foodService.findByFood3() == null && healthService.findByHealth3() == null && transportService.findByTransport3() == null) {
            response.setExpense(studyService.findByStudy3());
            return response;
        } else if (foodService.findByFood3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null) {
            response.setExpense(healthService.findByHealth3());
            return response;
        } else if (healthService.findByHealth3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null) {
            response.setExpense(foodService.findByFood3());
            return response;
        } else if (foodService.findByFood3() == null && healthService.findByHealth3() == null) {
            response.setExpense(studyService.findByStudy3() + transportService.findByTransport3());
            return response;
        } else if (foodService.findByFood3() == null && studyService.findByStudy3() == null) {
            response.setExpense(healthService.findByHealth3() + transportService.findByTransport3());
            return response;
        } else if (foodService.findByFood3() == null && transportService.findByTransport3() == null) {
            response.setExpense(healthService.findByHealth3() + studyService.findByStudy3());
            return response;
        } else if (healthService.findByHealth3() == null && studyService.findByStudy3() == null) {
            response.setExpense(foodService.findByFood3() + transportService.findByTransport3());
            return response;
        } else if (healthService.findByHealth3() == null && transportService.findByTransport3() == null) {
            response.setExpense(foodService.findByFood3() + studyService.findByStudy3());
            return response;
        } else if (studyService.findByStudy3() == null && transportService.findByTransport3() == null) {
            response.setExpense(foodService.findByFood3() + healthService.findByHealth3());
            return response;
        } else if (foodService.findByFood3() == null) {
            response.setExpense(healthService.findByHealth3() + studyService.findByStudy3() + transportService.findByTransport3());
            return response;
        } else if (healthService.findByHealth3() == null) {
            response.setExpense(foodService.findByFood3() + studyService.findByStudy3() + transportService.findByTransport3());
            return response;
        } else if (studyService.findByStudy3() == null) {
            response.setExpense(healthService.findByHealth3() + foodService.findByFood3() + transportService.findByTransport3());
            return response;
        } else if (transportService.findByTransport3() == null) {
            response.setExpense(healthService.findByHealth3() + studyService.findByStudy3() + foodService.findByFood3());
            return response;
        }
        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        expense.setLogin_date(createdTimestamp);
        expense.setExpense(foodService.findByFood3() + healthService.findByHealth3() + studyService.findByStudy3() + transportService.findByTransport3());
        expenseService.saveExpense(expense);
        response.setExpense(foodService.findByFood3() + healthService.findByHealth3() + studyService.findByStudy3() + transportService.findByTransport3());

        return response;
    }

    @RequestMapping(value = "/getexpense4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public ExpenseResponse response8() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        Expense expense = new Expense();
        ExpenseResponse response = new ExpenseResponse();
        ExpenseService expenseService = (ExpenseService) context.getBean("expenseService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        TransportService transportService = (TransportService) context.getBean("transportService");
          if(foodService.findByFood4() == null && healthService.findByHealth4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null){
             response.setExpense(0);
            return response;
        }else if (foodService.findByFood4() == null && healthService.findByHealth4() == null && studyService.findByStudy4() == null) {
            response.setExpense(transportService.findByTransport4());
            return response;
        } else if (foodService.findByFood4() == null && healthService.findByHealth4() == null && transportService.findByTransport4() == null) {
            response.setExpense(studyService.findByStudy4());
            return response;
        } else if (foodService.findByFood4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null) {
            response.setExpense(healthService.findByHealth4());
            return response;
        } else if (healthService.findByHealth4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null) {
            response.setExpense(foodService.findByFood4());
            return response;
        } else if (foodService.findByFood4() == null && healthService.findByHealth4() == null) {
            response.setExpense(studyService.findByStudy4() + transportService.findByTransport4());
            return response;
        } else if (foodService.findByFood4() == null && studyService.findByStudy4() == null) {
            response.setExpense(healthService.findByHealth4() + transportService.findByTransport4());
            return response;
        } else if (foodService.findByFood4() == null && transportService.findByTransport4() == null) {
            response.setExpense(healthService.findByHealth4() + studyService.findByStudy4());
            return response;
        } else if (healthService.findByHealth4() == null && studyService.findByStudy4() == null) {
            response.setExpense(foodService.findByFood4() + transportService.findByTransport4());
            return response;
        } else if (healthService.findByHealth4() == null && transportService.findByTransport4() == null) {
            response.setExpense(foodService.findByFood4() + studyService.findByStudy4());
            return response;
        } else if (studyService.findByStudy4() == null && transportService.findByTransport4() == null) {
            response.setExpense(foodService.findByFood4() + healthService.findByHealth4());
            return response;
        } else if (foodService.findByFood4() == null) {
            response.setExpense(healthService.findByHealth4() + studyService.findByStudy4() + transportService.findByTransport4());
            return response;
        } else if (healthService.findByHealth4() == null) {
            response.setExpense(foodService.findByFood4() + studyService.findByStudy4() + transportService.findByTransport4());
            return response;
        } else if (studyService.findByStudy4() == null) {
            response.setExpense(healthService.findByHealth4() + foodService.findByFood4() + transportService.findByTransport4());
            return response;
        } else if (transportService.findByTransport4() == null) {
            response.setExpense(healthService.findByHealth4() + studyService.findByStudy4() + foodService.findByFood4());
            return response;
        }
        long now = System.currentTimeMillis();
        Date createdTimestamp = new Date(now);

        expense.setLogin_date(createdTimestamp);
        expense.setExpense(foodService.findByFood4() + healthService.findByHealth4() + studyService.findByStudy4() + transportService.findByTransport4());
        expenseService.saveExpense(expense);
        response.setExpense(foodService.findByFood4() + healthService.findByHealth4() + studyService.findByStudy4() + transportService.findByTransport4());

        return response;
    }

    @RequestMapping(value = "/getbalance1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public BalanceResponse response9() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        BalanceResponse response = new BalanceResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        TransportService transportService = (TransportService) context.getBean("transportService");
        
       if(foodService.findByFood1() == null && healthService.findByHealth1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null && incomeService.findByIncome1() ==null){
             response.setBalance(0);
            return response;
        }else if (foodService.findByFood1() == null && healthService.findByHealth1() == null && studyService.findByStudy1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-transportService.findByTransport1());
            return response;
        } else if (foodService.findByFood1() == null && healthService.findByHealth1() == null && transportService.findByTransport1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-studyService.findByStudy1());
            return response;
        } else if (foodService.findByFood1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-healthService.findByHealth1());
            return response;
        } else if (healthService.findByHealth1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-foodService.findByFood1());
            return response;
        } else if (foodService.findByFood1() == null && healthService.findByHealth1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(studyService.findByStudy1() + transportService.findByTransport1()));
            return response;
        } else if (foodService.findByFood1() == null && studyService.findByStudy1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(healthService.findByHealth1() + transportService.findByTransport1()));
            return response;
        } else if (foodService.findByFood1() == null && transportService.findByTransport1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(healthService.findByHealth1() + studyService.findByStudy1()));
            return response;
        } else if (healthService.findByHealth1() == null && studyService.findByStudy1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(foodService.findByFood1() + transportService.findByTransport1()));
            return response;
        } else if (healthService.findByHealth1() == null && transportService.findByTransport1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(foodService.findByFood1() + studyService.findByStudy1()));
            return response;
        } else if (studyService.findByStudy1() == null && transportService.findByTransport1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(foodService.findByFood1() + healthService.findByHealth1()));
            return response;
        } else if (foodService.findByFood1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(healthService.findByHealth1() + studyService.findByStudy1() + transportService.findByTransport1()));
            return response;
        } else if (healthService.findByHealth1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(foodService.findByFood1() + studyService.findByStudy1() + transportService.findByTransport1()));
            return response;
        } else if (studyService.findByStudy1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(healthService.findByHealth1() + foodService.findByFood1() + transportService.findByTransport1()));
            return response;
        } else if (transportService.findByTransport1() == null && incomeService.findByIncome1() ==null) {
            response.setBalance(0-(healthService.findByHealth1() + studyService.findByStudy1() + foodService.findByFood1()));
            return response;
        }else if(foodService.findByFood1() == null && healthService.findByHealth1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null){
             response.setBalance(incomeService.findByIncome1());
            return response;
        }else if (foodService.findByFood1() == null && healthService.findByHealth1() == null && studyService.findByStudy1() == null) {
            response.setBalance(incomeService.findByIncome1() -transportService.findByTransport1());
            return response;
        } else if (foodService.findByFood1() == null && healthService.findByHealth1() == null && transportService.findByTransport1() == null) {
            response.setBalance(incomeService.findByIncome1() -studyService.findByStudy1());
            return response;
        } else if (foodService.findByFood1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null) {
            response.setBalance(incomeService.findByIncome1() -healthService.findByHealth1());
            return response;
        } else if (healthService.findByHealth1() == null && studyService.findByStudy1() == null && transportService.findByTransport1() == null) {
            response.setBalance(incomeService.findByIncome1() -foodService.findByFood1());
            return response;
        } else if (foodService.findByFood1() == null && healthService.findByHealth1() == null) {
            response.setBalance(incomeService.findByIncome1() -(studyService.findByStudy1() + transportService.findByTransport1()));
            return response;
        } else if (foodService.findByFood1() == null && studyService.findByStudy1() == null) {
            response.setBalance(incomeService.findByIncome1() -(healthService.findByHealth1() + transportService.findByTransport1()));
            return response;
        } else if (foodService.findByFood1() == null && transportService.findByTransport1() == null) {
            response.setBalance(incomeService.findByIncome1() -(healthService.findByHealth1() + studyService.findByStudy1()));
            return response;
        } else if (healthService.findByHealth1() == null && studyService.findByStudy1() == null) {
            response.setBalance(incomeService.findByIncome1() -(foodService.findByFood1() + transportService.findByTransport1()));
            return response;
        } else if (healthService.findByHealth1() == null && transportService.findByTransport1() == null) {
            response.setBalance(incomeService.findByIncome1() -(foodService.findByFood1() + studyService.findByStudy1()));
            return response;
        } else if (studyService.findByStudy1() == null && transportService.findByTransport1() == null) {
            response.setBalance(incomeService.findByIncome1() -(foodService.findByFood1() + healthService.findByHealth1()));
            return response;
        } else if (foodService.findByFood1() == null) {
            response.setBalance(incomeService.findByIncome1() -(healthService.findByHealth1() + studyService.findByStudy1() + transportService.findByTransport1()));
            return response;
        } else if (healthService.findByHealth1() == null) {
            response.setBalance(incomeService.findByIncome1() -(foodService.findByFood1() + studyService.findByStudy1() + transportService.findByTransport1()));
            return response;
        } else if (studyService.findByStudy1() == null) {
            response.setBalance(incomeService.findByIncome1() -(healthService.findByHealth1() + foodService.findByFood1() + transportService.findByTransport1()));
            return response;
        } else if (transportService.findByTransport1() == null) {
            response.setBalance(incomeService.findByIncome1() -(healthService.findByHealth1() + studyService.findByStudy1() + foodService.findByFood1()));
            return response;
        }
      
        response.setBalance(incomeService.findByIncome1() -(foodService.findByFood1() + healthService.findByHealth1() + studyService.findByStudy1() + transportService.findByTransport1()));

        return response;

    }

    @RequestMapping(value = "/getbalance2", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public BalanceResponse response10() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        BalanceResponse response = new BalanceResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        TransportService transportService = (TransportService) context.getBean("transportService");
     if(foodService.findByFood2() == null && healthService.findByHealth2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null && incomeService.findByIncome2() ==null){
             response.setBalance(0);
            return response;
        }else if (foodService.findByFood2() == null && healthService.findByHealth2() == null && studyService.findByStudy2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-transportService.findByTransport2());
            return response;
        } else if (foodService.findByFood2() == null && healthService.findByHealth2() == null && transportService.findByTransport2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-studyService.findByStudy2());
            return response;
        } else if (foodService.findByFood2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-healthService.findByHealth2());
            return response;
        } else if (healthService.findByHealth2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-foodService.findByFood2());
            return response;
        } else if (foodService.findByFood2() == null && healthService.findByHealth2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(studyService.findByStudy2() + transportService.findByTransport2()));
            return response;
        } else if (foodService.findByFood2() == null && studyService.findByStudy2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(healthService.findByHealth2() + transportService.findByTransport2()));
            return response;
        } else if (foodService.findByFood2() == null && transportService.findByTransport2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(healthService.findByHealth2() + studyService.findByStudy2()));
            return response;
        } else if (healthService.findByHealth2() == null && studyService.findByStudy2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(foodService.findByFood2() + transportService.findByTransport2()));
            return response;
        } else if (healthService.findByHealth2() == null && transportService.findByTransport2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(foodService.findByFood2() + studyService.findByStudy2()));
            return response;
        } else if (studyService.findByStudy2() == null && transportService.findByTransport2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(foodService.findByFood2() + healthService.findByHealth2()));
            return response;
        } else if (foodService.findByFood2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(healthService.findByHealth2() + studyService.findByStudy2() + transportService.findByTransport2()));
            return response;
        } else if (healthService.findByHealth2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(foodService.findByFood2() + studyService.findByStudy2() + transportService.findByTransport2()));
            return response;
        } else if (studyService.findByStudy2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(healthService.findByHealth2() + foodService.findByFood2() + transportService.findByTransport2()));
            return response;
        } else if (transportService.findByTransport2() == null && incomeService.findByIncome2() ==null) {
            response.setBalance(0-(healthService.findByHealth2() + studyService.findByStudy2() + foodService.findByFood2()));
            return response;
        }else if(foodService.findByFood2() == null && healthService.findByHealth2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null){
             response.setBalance(incomeService.findByIncome2());
            return response;
        }else if (foodService.findByFood2() == null && healthService.findByHealth2() == null && studyService.findByStudy2() == null) {
            response.setBalance(incomeService.findByIncome2() -transportService.findByTransport2());
            return response;
        } else if (foodService.findByFood2() == null && healthService.findByHealth2() == null && transportService.findByTransport2() == null) {
            response.setBalance(incomeService.findByIncome2() -studyService.findByStudy2());
            return response;
        } else if (foodService.findByFood2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null) {
            response.setBalance(incomeService.findByIncome2() -healthService.findByHealth2());
            return response;
        } else if (healthService.findByHealth2() == null && studyService.findByStudy2() == null && transportService.findByTransport2() == null) {
            response.setBalance(incomeService.findByIncome2() -foodService.findByFood2());
            return response;
        } else if (foodService.findByFood2() == null && healthService.findByHealth2() == null) {
            response.setBalance(incomeService.findByIncome2() -(studyService.findByStudy2() + transportService.findByTransport2()));
            return response;
        } else if (foodService.findByFood2() == null && studyService.findByStudy2() == null) {
            response.setBalance(incomeService.findByIncome2() -(healthService.findByHealth2() + transportService.findByTransport2()));
            return response;
        } else if (foodService.findByFood2() == null && transportService.findByTransport2() == null) {
            response.setBalance(incomeService.findByIncome2() -(healthService.findByHealth2() + studyService.findByStudy2()));
            return response;
        } else if (healthService.findByHealth2() == null && studyService.findByStudy2() == null) {
            response.setBalance(incomeService.findByIncome2() -(foodService.findByFood2() + transportService.findByTransport2()));
            return response;
        } else if (healthService.findByHealth2() == null && transportService.findByTransport2() == null) {
            response.setBalance(incomeService.findByIncome2() -(foodService.findByFood2() + studyService.findByStudy2()));
            return response;
        } else if (studyService.findByStudy2() == null && transportService.findByTransport2() == null) {
            response.setBalance(incomeService.findByIncome2() -(foodService.findByFood2() + healthService.findByHealth2()));
            return response;
        } else if (foodService.findByFood2() == null) {
            response.setBalance(incomeService.findByIncome2() -(healthService.findByHealth2() + studyService.findByStudy2() + transportService.findByTransport2()));
            return response;
        } else if (healthService.findByHealth2() == null) {
            response.setBalance(incomeService.findByIncome2() -(foodService.findByFood2() + studyService.findByStudy2() + transportService.findByTransport2()));
            return response;
        } else if (studyService.findByStudy2() == null) {
            response.setBalance(incomeService.findByIncome2() -(healthService.findByHealth2() + foodService.findByFood2() + transportService.findByTransport2()));
            return response;
        } else if (transportService.findByTransport2() == null) {
            response.setBalance(incomeService.findByIncome2() -(healthService.findByHealth2() + studyService.findByStudy2() + foodService.findByFood2()));
            return response;
        }
      
        response.setBalance(incomeService.findByIncome2() -(foodService.findByFood2() + healthService.findByHealth2() + studyService.findByStudy2() + transportService.findByTransport2()));

        return response;
    }
    @RequestMapping(value = "/getbalance3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public BalanceResponse response11() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        BalanceResponse response = new BalanceResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        TransportService transportService = (TransportService) context.getBean("transportService");
          if(foodService.findByFood3() == null && healthService.findByHealth3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null && incomeService.findByIncome3() ==null){
             response.setBalance(0);
            return response;
        }else if (foodService.findByFood3() == null && healthService.findByHealth3() == null && studyService.findByStudy3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-transportService.findByTransport3());
            return response;
        } else if (foodService.findByFood3() == null && healthService.findByHealth3() == null && transportService.findByTransport3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-studyService.findByStudy3());
            return response;
        } else if (foodService.findByFood3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-healthService.findByHealth3());
            return response;
        } else if (healthService.findByHealth3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-foodService.findByFood3());
            return response;
        } else if (foodService.findByFood3() == null && healthService.findByHealth3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(studyService.findByStudy3() + transportService.findByTransport3()));
            return response;
        } else if (foodService.findByFood3() == null && studyService.findByStudy3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(healthService.findByHealth3() + transportService.findByTransport3()));
            return response;
        } else if (foodService.findByFood3() == null && transportService.findByTransport3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(healthService.findByHealth3() + studyService.findByStudy3()));
            return response;
        } else if (healthService.findByHealth3() == null && studyService.findByStudy3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(foodService.findByFood3() + transportService.findByTransport3()));
            return response;
        } else if (healthService.findByHealth3() == null && transportService.findByTransport3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(foodService.findByFood3() + studyService.findByStudy3()));
            return response;
        } else if (studyService.findByStudy3() == null && transportService.findByTransport3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(foodService.findByFood3() + healthService.findByHealth3()));
            return response;
        } else if (foodService.findByFood3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(healthService.findByHealth3() + studyService.findByStudy3() + transportService.findByTransport3()));
            return response;
        } else if (healthService.findByHealth3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(foodService.findByFood3() + studyService.findByStudy3() + transportService.findByTransport3()));
            return response;
        } else if (studyService.findByStudy3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(healthService.findByHealth3() + foodService.findByFood3() + transportService.findByTransport3()));
            return response;
        } else if (transportService.findByTransport3() == null && incomeService.findByIncome3() ==null) {
            response.setBalance(0-(healthService.findByHealth3() + studyService.findByStudy3() + foodService.findByFood3()));
            return response;
        }else if(foodService.findByFood3() == null && healthService.findByHealth3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null){
             response.setBalance(incomeService.findByIncome3());
            return response;
        }else if (foodService.findByFood3() == null && healthService.findByHealth3() == null && studyService.findByStudy3() == null) {
            response.setBalance(incomeService.findByIncome3() -transportService.findByTransport3());
            return response;
        } else if (foodService.findByFood3() == null && healthService.findByHealth3() == null && transportService.findByTransport3() == null) {
            response.setBalance(incomeService.findByIncome3() -studyService.findByStudy3());
            return response;
        } else if (foodService.findByFood3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null) {
            response.setBalance(incomeService.findByIncome3() -healthService.findByHealth3());
            return response;
        } else if (healthService.findByHealth3() == null && studyService.findByStudy3() == null && transportService.findByTransport3() == null) {
            response.setBalance(incomeService.findByIncome3() -foodService.findByFood3());
            return response;
        } else if (foodService.findByFood3() == null && healthService.findByHealth3() == null) {
            response.setBalance(incomeService.findByIncome3() -(studyService.findByStudy3() + transportService.findByTransport3()));
            return response;
        } else if (foodService.findByFood3() == null && studyService.findByStudy3() == null) {
            response.setBalance(incomeService.findByIncome3() -(healthService.findByHealth3() + transportService.findByTransport3()));
            return response;
        } else if (foodService.findByFood3() == null && transportService.findByTransport3() == null) {
            response.setBalance(incomeService.findByIncome3() -(healthService.findByHealth3() + studyService.findByStudy3()));
            return response;
        } else if (healthService.findByHealth3() == null && studyService.findByStudy3() == null) {
            response.setBalance(incomeService.findByIncome3() -(foodService.findByFood3() + transportService.findByTransport3()));
            return response;
        } else if (healthService.findByHealth3() == null && transportService.findByTransport3() == null) {
            response.setBalance(incomeService.findByIncome3() -(foodService.findByFood3() + studyService.findByStudy3()));
            return response;
        } else if (studyService.findByStudy3() == null && transportService.findByTransport3() == null) {
            response.setBalance(incomeService.findByIncome3() -(foodService.findByFood3() + healthService.findByHealth3()));
            return response;
        } else if (foodService.findByFood3() == null) {
            response.setBalance(incomeService.findByIncome3() -(healthService.findByHealth3() + studyService.findByStudy3() + transportService.findByTransport3()));
            return response;
        } else if (healthService.findByHealth3() == null) {
            response.setBalance(incomeService.findByIncome3() -(foodService.findByFood3() + studyService.findByStudy3() + transportService.findByTransport3()));
            return response;
        } else if (studyService.findByStudy3() == null) {
            response.setBalance(incomeService.findByIncome3() -(healthService.findByHealth3() + foodService.findByFood3() + transportService.findByTransport3()));
            return response;
        } else if (transportService.findByTransport3() == null) {
            response.setBalance(incomeService.findByIncome3() -(healthService.findByHealth3() + studyService.findByStudy3() + foodService.findByFood3()));
            return response;
        }
      
        response.setBalance(incomeService.findByIncome3() -(foodService.findByFood3() + healthService.findByHealth3() + studyService.findByStudy3() + transportService.findByTransport3()));

        return response;
    }

    @RequestMapping(value = "/getbalance4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public BalanceResponse response12() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        BalanceResponse response = new BalanceResponse();
        IncomeService incomeService = (IncomeService) context.getBean("incomeService");
        FoodService foodService = (FoodService) context.getBean("foodService");
        StudyService studyService = (StudyService) context.getBean("studyService");
        HealthService healthService = (HealthService) context.getBean("healthService");
        TransportService transportService = (TransportService) context.getBean("transportService");
         if(foodService.findByFood4() == null && healthService.findByHealth4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null && incomeService.findByIncome4() ==null){
             response.setBalance(0);
            return response;
        }else if (foodService.findByFood4() == null && healthService.findByHealth4() == null && studyService.findByStudy4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-transportService.findByTransport4());
            return response;
        } else if (foodService.findByFood4() == null && healthService.findByHealth2() == null && transportService.findByTransport4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-studyService.findByStudy4());
            return response;
        } else if (foodService.findByFood4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-healthService.findByHealth4());
            return response;
        } else if (healthService.findByHealth4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-foodService.findByFood4());
            return response;
        } else if (foodService.findByFood4() == null && healthService.findByHealth4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(studyService.findByStudy4() + transportService.findByTransport4()));
            return response;
        } else if (foodService.findByFood4() == null && studyService.findByStudy4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(healthService.findByHealth4() + transportService.findByTransport4()));
            return response;
        } else if (foodService.findByFood4() == null && transportService.findByTransport4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(healthService.findByHealth4() + studyService.findByStudy4()));
            return response;
        } else if (healthService.findByHealth4() == null && studyService.findByStudy4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(foodService.findByFood4() + transportService.findByTransport4()));
            return response;
        } else if (healthService.findByHealth4() == null && transportService.findByTransport4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(foodService.findByFood4() + studyService.findByStudy4()));
            return response;
        } else if (studyService.findByStudy4() == null && transportService.findByTransport4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(foodService.findByFood4() + healthService.findByHealth4()));
            return response;
        } else if (foodService.findByFood4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(healthService.findByHealth4() + studyService.findByStudy4() + transportService.findByTransport4()));
            return response;
        } else if (healthService.findByHealth4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(foodService.findByFood4() + studyService.findByStudy4() + transportService.findByTransport4()));
            return response;
        } else if (studyService.findByStudy4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(healthService.findByHealth4() + foodService.findByFood4() + transportService.findByTransport4()));
            return response;
        } else if (transportService.findByTransport4() == null && incomeService.findByIncome4() ==null) {
            response.setBalance(0-(healthService.findByHealth4() + studyService.findByStudy4() + foodService.findByFood4()));
            return response;
        }else if(foodService.findByFood4() == null && healthService.findByHealth4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null){
             response.setBalance(incomeService.findByIncome4());
            return response;
        }else if (foodService.findByFood4() == null && healthService.findByHealth4() == null && studyService.findByStudy4() == null) {
            response.setBalance(incomeService.findByIncome4() -transportService.findByTransport4());
            return response;
        } else if (foodService.findByFood4() == null && healthService.findByHealth4() == null && transportService.findByTransport4() == null) {
            response.setBalance(incomeService.findByIncome4() -studyService.findByStudy4());
            return response;
        } else if (foodService.findByFood4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null) {
            response.setBalance(incomeService.findByIncome4() -healthService.findByHealth4());
            return response;
        } else if (healthService.findByHealth4() == null && studyService.findByStudy4() == null && transportService.findByTransport4() == null) {
            response.setBalance(incomeService.findByIncome4() -foodService.findByFood4());
            return response;
        } else if (foodService.findByFood4() == null && healthService.findByHealth4() == null) {
            response.setBalance(incomeService.findByIncome4() -(studyService.findByStudy4() + transportService.findByTransport4()));
            return response;
        } else if (foodService.findByFood4() == null && studyService.findByStudy4() == null) {
            response.setBalance(incomeService.findByIncome4() -(healthService.findByHealth4() + transportService.findByTransport4()));
            return response;
        } else if (foodService.findByFood4() == null && transportService.findByTransport4() == null) {
            response.setBalance(incomeService.findByIncome4() -(healthService.findByHealth4() + studyService.findByStudy4()));
            return response;
        } else if (healthService.findByHealth4() == null && studyService.findByStudy4() == null) {
            response.setBalance(incomeService.findByIncome4() -(foodService.findByFood4() + transportService.findByTransport4()));
            return response;
        } else if (healthService.findByHealth4() == null && transportService.findByTransport4() == null) {
            response.setBalance(incomeService.findByIncome4() -(foodService.findByFood4() + studyService.findByStudy4()));
            return response;
        } else if (studyService.findByStudy4() == null && transportService.findByTransport4() == null) {
            response.setBalance(incomeService.findByIncome4() -(foodService.findByFood4() + healthService.findByHealth4()));
            return response;
        } else if (foodService.findByFood4() == null) {
            response.setBalance(incomeService.findByIncome4() -(healthService.findByHealth4() + studyService.findByStudy4() + transportService.findByTransport4()));
            return response;
        } else if (healthService.findByHealth4() == null) {
            response.setBalance(incomeService.findByIncome4() -(foodService.findByFood4() + studyService.findByStudy4() + transportService.findByTransport4()));
            return response;
        } else if (studyService.findByStudy4() == null) {
            response.setBalance(incomeService.findByIncome4() -(healthService.findByHealth4() + foodService.findByFood4() + transportService.findByTransport4()));
            return response;
        } else if (transportService.findByTransport4() == null) {
            response.setBalance(incomeService.findByIncome4() -(healthService.findByHealth4() + studyService.findByStudy4() + foodService.findByFood4()));
            return response;
        }
      
        response.setBalance(incomeService.findByIncome4() -(foodService.findByFood4() + healthService.findByHealth4() + studyService.findByStudy4() + transportService.findByTransport4()));

        return response;
    }

    @RequestMapping(value = "/getfood1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public FoodResponse response13() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        FoodResponse response = new FoodResponse();
        FoodService foodService = (FoodService) context.getBean("foodService");
        if (foodService.findByFood1() == null) {
            response.setFood(0);
            return response;
        }
        response.setFood(foodService.findByFood1());

        return response;
    }

    @RequestMapping(value = "/getfood2", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public FoodResponse response14() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        FoodResponse response = new FoodResponse();
        FoodService foodService = (FoodService) context.getBean("foodService");
        if (foodService.findByFood2() == null) {
            response.setFood(0);
            return response;
        }
        response.setFood(foodService.findByFood2());

        return response;
    }

    @RequestMapping(value = "/getfood3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public FoodResponse response15() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        FoodResponse response = new FoodResponse();
        FoodService foodService = (FoodService) context.getBean("foodService");
        if (foodService.findByFood3() == null) {
            response.setFood(0);
            return response;
        }
        response.setFood(foodService.findByFood3());

        return response;

    }

    @RequestMapping(value = "/getfood4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public FoodResponse response16() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();

        FoodResponse response = new FoodResponse();
        FoodService foodService = (FoodService) context.getBean("foodService");
        if (foodService.findByFood4() == null) {
            response.setFood(0);
            return response;
        }
        response.setFood(foodService.findByFood4());

        return response;
    }

    @RequestMapping(value = "/gethealth1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HealthResponse response17() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        HealthResponse response = new HealthResponse();
        HealthService healthService = (HealthService) context.getBean("healthService");
        if (healthService.findByHealth1() == null) {
            response.setHealth(0);
            return response;
        }
        response.setHealth(healthService.findByHealth1());

        return response;
    }

    @RequestMapping(value = "/gethealth2", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HealthResponse response18() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        HealthResponse response = new HealthResponse();
        HealthService healthService = (HealthService) context.getBean("healthService");
        if (healthService.findByHealth2() == null) {
            response.setHealth(0);
            return response;
        }
        response.setHealth(healthService.findByHealth2());

        return response;
    }

    @RequestMapping(value = "/gethealth3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HealthResponse response19() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        HealthResponse response = new HealthResponse();
        HealthService healthService = (HealthService) context.getBean("healthService");
        if (healthService.findByHealth3() == null) {
            response.setHealth(0);
            return response;
        }
        response.setHealth(healthService.findByHealth3());

        return response;
    }

    @RequestMapping(value = "/gethealth4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HealthResponse response20() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        HealthResponse response = new HealthResponse();
        HealthService healthService = (HealthService) context.getBean("healthService");
        if (healthService.findByHealth4() == null) {
            response.setHealth(0);
            return response;
        }
        response.setHealth(healthService.findByHealth4());

        return response;
    }

    @RequestMapping(value = "/getstudy1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public StudyResponse response21() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        StudyResponse response = new StudyResponse();
        StudyService studyService = (StudyService) context.getBean("studyService");
        if (studyService.findByStudy1() == null) {
            response.setStudy(0);
            return response;
        }
        response.setStudy(studyService.findByStudy1());

        return response;
    }

    @RequestMapping(value = "/getstudy2", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public StudyResponse response22() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        StudyResponse response = new StudyResponse();
        StudyService studyService = (StudyService) context.getBean("studyService");
        if (studyService.findByStudy2() == null) {
            response.setStudy(0);
            return response;
        }
        response.setStudy(studyService.findByStudy2());

        return response;
    }

    @RequestMapping(value = "/getstudy3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public StudyResponse response23() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        StudyResponse response = new StudyResponse();
        StudyService studyService = (StudyService) context.getBean("studyService");
        if (studyService.findByStudy3() == null) {
            response.setStudy(0);
            return response;
        }
        response.setStudy(studyService.findByStudy3());

        return response;
    }

    @RequestMapping(value = "/getstudy4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public StudyResponse response24() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        StudyResponse response = new StudyResponse();
        StudyService studyService = (StudyService) context.getBean("studyService");
        if (studyService.findByStudy4() == null) {
            response.setStudy(0);
            return response;
        }
        response.setStudy(studyService.findByStudy4());

        return response;
    }

    @RequestMapping(value = "/gettransport1", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public TransportResponse response25() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        TransportResponse response = new TransportResponse();
        TransportService transportService = (TransportService) context.getBean("transportService");
        if (transportService.findByTransport1() == null) {
            response.setTransport(0);
            return response;
        }
        response.setTransport(transportService.findByTransport1());

        return response;
    }

    @RequestMapping(value = "/gettransport2", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public TransportResponse response26() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        TransportResponse response = new TransportResponse();
        TransportService transportService = (TransportService) context.getBean("transportService");
        if (transportService.findByTransport2() == null) {
            response.setTransport(0);
            return response;
        }
        response.setTransport(transportService.findByTransport2());

        return response;
    }

    @RequestMapping(value = "/gettransport3", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public TransportResponse response27() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        TransportResponse response = new TransportResponse();
        TransportService transportService = (TransportService) context.getBean("transportService");
        if (transportService.findByTransport3() == null) {
            response.setTransport(0);
            return response;
        }
        response.setTransport(transportService.findByTransport3());

        return response;
    }

    @RequestMapping(value = "/gettransport4", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public TransportResponse response28() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.damir.wallet");
        context.refresh();
        TransportResponse response = new TransportResponse();

        TransportService transportService = (TransportService) context.getBean("transportService");
        if (transportService.findByTransport4() == null) {
            response.setTransport(0);
            return response;
        }
        response.setTransport(transportService.findByTransport4());

        return response;
    }
}
