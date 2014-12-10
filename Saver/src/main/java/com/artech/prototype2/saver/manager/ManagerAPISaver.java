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
public class ManagerAPISaver implements API {

    private static ManagerAPISaver instance;

    protected Map<String, Map<AbstractSUBD, CommonDB>> container;

    public static ManagerAPISaver getInstance() {
        if (instance == null) {
            instance = new ManagerAPISaver();
        }
        return instance;
    }

    private ManagerAPISaver() {
        container = new HashMap<String, Map<AbstractSUBD, CommonDB>>();
    }

    /**
     * Функция регестрации связь наименования действия с конкретной субд и с
     * конкретным испольнителем
     *
     * @param label наименование действия
     * @param subd конкретная субд
     * @param test исполнитель функционала
     */
    public void registry(String label, AbstractSUBD db, CommonDB test) {
        Map<AbstractSUBD, CommonDB> temp = new HashMap<AbstractSUBD, CommonDB>();
        temp.put(db, test);
        container.put(label, temp);
    }

    /**
     * По меткам получить испольнителя
     *
     * @param label метка действия
     * @param db метка субд
     * @return объект-исполнитель
     */
    protected CommonDB get(String label, AbstractSUBD db) {
        Map<AbstractSUBD, CommonDB> temp = container.get(label);
        return temp.get(db);
    }

    /**
     * Cоздание БД и пролика скриптов таблиц использованную выбранную СУБД
     *
     * @param db выбранная субд
     * @param label метка действия
     */
    public void createDB(String label, AbstractSUBD db) {
        CommonDB test = get(label, db);
        if (test != null) {
            ((CreateDataBase) test).createDB(db);
        }
    }

    /**
     * Сохранить сущность использованную выбранную субд
     *
     * @param db используемая субд
     * @param label метка действия
     * @param entity сущность
     */
    public void save(String label, AbstractSUBD db, Entity entity) {
        CommonDB dao = (Dao) get(label, db);
        if (dao != null) {
            ((AbstractDao) dao).save(entity);
        }
    }

    public void delete(String label, AbstractSUBD db, Entity entity) {
        CommonDB dao = (Dao) get(label, db);
        if (dao != null) {
            ((AbstractDao) dao).delete(entity);
        }
    }

    public Entity getById(String label, AbstractSUBD db, Entity entity) {
        CommonDB dao = (Dao) get(label, db);
        if (dao != null);
        return entity;
    }

    public List<Entity> getAll(String label, AbstractSUBD db) {
        CommonDB dao = (Dao) get(label, db);
        List<Entity> entities = null;
        if (dao != null) {
            entities = ((AbstractDao) dao).getAll();
        }
        return entities;
    }

    public void update(String label, AbstractSUBD db, Entity entity) {
        CommonDB dao = (Dao) get(label, db);
        if (dao != null) {
            ((AbstractDao) dao).update(entity);
        }
    }

}
