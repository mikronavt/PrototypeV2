/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.saver.hiber.util;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author CANDY
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Configuration configure;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            configure = new Configuration().configure("hibernate\\hibernate-mysql.cfg.xml");
            sessionFactory = configure.buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * получить сессию хибернейт
     * @param db - выбранная база данных
     * @return 
     */
    public static SessionFactory getSessionFactory(AbstractSUBD db) {
        configure.setProperty("hibernate.connection.username", db.getLogin());
        configure.setProperty("hibernate.connection.password", db.getPassword());
        return sessionFactory;
    }
}
