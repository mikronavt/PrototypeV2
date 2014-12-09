/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.dao;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.manager.CommonDB;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author CANDY
 */
public interface Dao<ID extends Serializable, Type extends Entity> extends CommonDB {

    void save(Type entity);

    void delete(Type entity);

    Type getById(Type entity);

    List<Type> getAll();

    void update(Type entity);
}
