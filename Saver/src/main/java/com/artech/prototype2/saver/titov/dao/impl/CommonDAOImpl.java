/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.dao.impl;

import com.artech.prototype2.saver.titov.dao.DAO;
import com.artech.prototype2.saver.bardakov.utils.HibernateUtil;
import com.artech.prototype2.saver.titov.entity.EntityDB;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;

/**
 *
 * @author Zhenya
 */
/**
 * абстрактный класс наследуется от интерфейса DAO
 *
 * @author Zhenya
 * @param <T>
 * @param <PK>
 */
public class CommonDAOImpl<T extends EntityDB, PK extends Serializable> implements DAO<T, PK> {

    private Class<T> type;

    public CommonDAOImpl(SessionFactory sessionFactory, Class<T> type) {
        this.type = type;
    }

    protected Session getSession() {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (HibernateException e) {
            System.out.println("error to create session");
        }
        return session;
    }

    public void addObject(T c) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }

    public void updateObject(T c) {
        Session session = getSession();
        if (session == null) {
            return;
        }
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
        session.close();
    }

    public T getObjectById(PK id) {
        T value = (T) getSession().get(type, id);
        if (value == null) {
            return null;
        }
        if (value instanceof HibernateProxy) {
            Hibernate.initialize(value);
            value = (T) ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation();
        }
        return value;
    }

    public List<T> getAllObjects() {
        Criteria crit = getSession().createCriteria(type);
        return crit.list();
    }

    public void deleteObject(T c) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
        session.close();
    }
}
