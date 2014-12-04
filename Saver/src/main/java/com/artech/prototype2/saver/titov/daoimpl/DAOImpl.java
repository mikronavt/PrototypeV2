/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.daoimpl;

import com.artech.prototype2.saver.titov.entity.EntityDB;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Zhenya
 */
/**
 * абстрактный класс наследуется от интерфейса DAO
 * @author Zhenya
 * @param <T>
 * @param <PK> 
 */
abstract public class DAOImpl<T extends EntityDB,PK extends Serializable> implements DAO<T,PK>{
    protected Session getSession(){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();                        
        }
        catch(HibernateException e){
            System.out.println("error to create session");
        }
        return session;
    }
    
    public void addObject(T c){
        Session session = getSession();        
        if(session == null) return;        
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();                                        
        session.close();
    }
            
    public void updateObject(T c){
        Session session = getSession();
        if(session == null) return;        
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
        session.close();
    }    
    abstract public T getObjectById(PK id);
    abstract public List<T> getAllObjects();
    public void deleteObject(T c){
        Session session = getSession();        
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
        session.close();
    }
}
