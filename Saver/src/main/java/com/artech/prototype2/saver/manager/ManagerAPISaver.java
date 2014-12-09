/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.saver.manager;

import com.artech.prototype2.saver.bardakov.api.API;
import com.artech.prototype2.saver.bardakov.dbo.AbstractSUBD;
import com.artech.prototype2.saver.bardakov.dbo.CreateDataBase;
import com.artech.prototype2.saver.bardakov.dbo.impl.MySQL;
import com.artech.prototype2.saver.dao.AbstractDao;
import com.artech.prototype2.saver.dao.Dao;
import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.saver.entity.Entity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CANDY
 */
public class ManagerAPISaver implements API{
    private static ManagerAPISaver instance;
    
    protected Map<String, CommonDB> container;

    public static ManagerAPISaver getInstance() {
        if(instance==null)
            instance = new ManagerAPISaver();
        return instance;
    }
    
    private ManagerAPISaver(){
        container = new HashMap<String, CommonDB>();
    }
    
    public void registry(String name, CommonDB test){
        container.put(name, test);
    }
    
    public void createDB(AbstractSUBD db) {
        CommonDB test = container.get("create_db");
        if(test!=null)
            ((CreateDataBase)test).createDB(db);
    }

    public void save(String label, Entity entity) {
        CommonDB dao = (Dao) container.get(label);
        if(dao!=null)
            ((AbstractDao)dao).save(entity);
    }

    public void delete(String label, Entity entity) {
        CommonDB dao = (Dao) container.get(label);
        if(dao!=null)
            ((AbstractDao)dao).delete(entity);
    }

    public Entity getById(String label, Entity entity) {
        CommonDB dao = (Dao) container.get(label);
        if(dao!=null);
        return entity;
    }

    public List<Entity> getAll(String label) {
        CommonDB dao = (Dao) container.get(label);
        List<Entity> entities = null;
        if(dao!=null)
             entities = ((AbstractDao)dao).getAll();
        return entities;
    }

    public void update(String label, Entity entity) {
    CommonDB dao = (Dao) container.get(label);
        if(dao!=null)
            ((AbstractDao)dao).update(entity);
    }
    
}
