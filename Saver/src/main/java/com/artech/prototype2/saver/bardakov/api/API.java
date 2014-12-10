/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.saver.bardakov.api;

import com.artech.prototype2.saver.bardakov.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.Entity;
import java.util.List;

/**
 * API модуля Saver
 * функционал, который может предоствить 
 * модуль
 * @author CANDY
 */
public interface API {
    
    /**
     * Создание БД
     * Создание таблиц
     * в указанной СУБД
     * @param db СУБД
     */
    void createDB(String label, AbstractSUBD db);
    
    /**
     * Сохранение сущности в БД
     * @param db выбранная бд
     * @param entity сущность для сохранения
     */
    void save(String label, AbstractSUBD db, Entity entity);
    
    void delete(String label, AbstractSUBD db, Entity entity);
    
    Entity getById(String label, AbstractSUBD db, Entity entity);
    
    List<Entity> getAll(String label, AbstractSUBD db);
    
    void update(String label, AbstractSUBD db, Entity entity);
    
}
