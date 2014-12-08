/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.dao.impl;

import com.artech.prototype2.saver.bardakov.entity.impl.IndexedWeb;
import com.artech.prototype2.saver.bardakov.utils.HibernateUtil;
import com.artech.prototype2.saver.titov.dao.IndexedWebDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.proxy.HibernateProxy;

/**
 *
 * @author CANDY
 */
public class IndexedWebDaoImpl implements IndexedWebDao {

    public Integer addObject(IndexedWeb entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ID = null;
        try {
            tx = session.beginTransaction();
            ID = (Integer) session.save(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ID;
    }

    public void updateObject(IndexedWeb entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer ID = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public IndexedWeb getObjectById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        IndexedWeb value = null;
        try {
            tx = session.beginTransaction();
            value = (IndexedWeb) session.get(IndexedWeb.class, id);
            if (value == null) {
                return null;
            }
            if (value instanceof HibernateProxy) {
                Hibernate.initialize(value);
                value = (IndexedWeb) ((HibernateProxy) value).getHibernateLazyInitializer().getImplementation();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return value;
    }

    public List<IndexedWeb> getAllObjects() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Criteria crit = null;
        try {
            tx = session.beginTransaction();
            crit = session.createCriteria(IndexedWeb.class);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return crit.list();
    }

    public void deleteObject(IndexedWeb entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
