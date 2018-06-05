/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.damir.wallet.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author codetech
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.damir.wallet.config"})
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {

    private static final Logger logger = Logger.getLogger(HibernateConfiguration.class);
    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        logger.debug("Inside HibernateConfiguration's sessionFactory method");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        logger.debug("Created LocalSessionFactoryBean. (sessionFactory method)");
        sessionFactory.setDataSource(getDataSource());
        logger.debug("DataSource set for sessionFactory");
        sessionFactory.setPackagesToScan(new String[]{"com.damir.wallet.model"});
        logger.debug("PackagesToScan set for sessionFactory");
        sessionFactory.setHibernateProperties(hibernateProperties());
        logger.debug("HibernateProperties set for sessionFactory");

        return sessionFactory;
    }

    @Bean
    public DataSource getDataSource() {
        logger.debug("Inside HibernateConfiguration's getDataSource method");
        logger.debug("Environment: " + environment.toString());
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        logger.debug("DriverManagerDataSource object created");
        dataSource.setDriverClassName(environment.getProperty("hibernate.connection.driver_class"));
        logger.debug("DriverClassName set for dataSource");
        dataSource.setUrl(environment.getProperty("hibernate.connection.url"));
        logger.debug("Url set for dataSource");
        dataSource.setUsername(environment.getProperty("hibernate.connection.username"));
        logger.debug("Username set for dataSource");
        dataSource.setPassword(environment.getProperty("hibernate.connection.password"));
        logger.debug("Password set for dataSource");

        return dataSource;
    }

    Properties hibernateProperties() {
        logger.debug("Inside HibernateConfiguration's hibernateProperties method.");
        logger.debug("Environment: " + environment.toString());
        return new Properties() {
            {
                setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
                logger.debug("hibernate.dialect property set");
                setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
                logger.debug("hibernate.show_sql property set");
                setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
                logger.debug("hibernate.format_sql property set");
            }
        };
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory session) {
        logger.debug("Inside HibernateConfiguration's transactionManager method");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        logger.debug("Created HibernateTransactionManager object");
        transactionManager.setSessionFactory(session);
        logger.debug("SessionFactory set for transactionManager to session: " + session.toString());
        return transactionManager;
    }
}
