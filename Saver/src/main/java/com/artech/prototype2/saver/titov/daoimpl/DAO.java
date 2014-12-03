/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.daoimpl;

import com.artech.prototype2.saver.titov.entity.EntityDB;
import java.io.Serializable;
import java.util.List;

/**
 * интерфейс для работы с БД
 * @param <T> объект который является помеченным интерфейсом EntityDB
 * @param <PK> первичный ключ 
 */
public interface DAO<T extends EntityDB,PK extends Serializable> {
    public void addObject(T c);
    public void updateObject(T c);
    public T getObjectById(PK id);
    public List<T> getAllObjects();
    public void deleteObject(T c);
}