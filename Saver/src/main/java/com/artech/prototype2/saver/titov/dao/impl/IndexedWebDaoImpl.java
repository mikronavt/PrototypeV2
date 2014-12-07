/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.saver.titov.dao.impl;

import com.artech.prototype2.saver.bardakov.entity.impl.IndexedWeb;
import java.io.Serializable;
import org.hibernate.SessionFactory;

/**
 *
 * @author CANDY
 */
public class IndexedWebDaoImpl extends CommonDAOImpl<IndexedWeb, Integer>{

    public IndexedWebDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, IndexedWeb.class);
    }
    
}
