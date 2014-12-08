/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.dao;

import com.artech.prototype2.saver.bardakov.entity.impl.IndexedWeb;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author CANDY
 */
public interface IndexedWebDao {

    public Integer addObject(IndexedWeb entity);

    public void updateObject(IndexedWeb entity);

    public IndexedWeb getObjectById(Integer id);

    public List<IndexedWeb> getAllObjects();

    public void deleteObject(IndexedWeb c);
}
