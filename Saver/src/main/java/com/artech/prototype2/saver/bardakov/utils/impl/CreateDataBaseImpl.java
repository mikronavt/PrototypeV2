/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.bardakov.utils.impl;

import com.artech.prototype2.saver.bardakov.utils.AbstractSUBD;
import com.artech.prototype2.saver.bardakov.utils.CreateDataBase;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.utils.bardakov.helpers.Helpers;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс занимается выполнением скриптов в очередности указанной в файле очереди
 *
 * @author CANDY
 */
public class CreateDataBaseImpl implements CreateDataBase {

    protected Resources res;

    private Helpers help = new Helpers();

    public CreateDataBaseImpl() {
//        ManagerAPISaver.getInstance().registry("create_db", this);
        res = new Resources();
    }

    /**
     * Метод занимается созданием БД
     */
    public void createDB(AbstractSUBD db) {
        String[] sricpts = res.getScriptsForDB(db.getScripts());
        Connection conn = jdbcConnection(db);
    }

    /**
     * Установление взаимодействия с CУБД
     */
    protected Connection jdbcConnection(AbstractSUBD db) {
        Connection conn = null;
        try{
            Class.forName(db.getDriverName());
            conn = (Connection) DriverManager.getConnection(db.getUrl(), db.getLogin(), db.getPassword());
            
        }catch(ClassNotFoundException cnfExp){
            cnfExp.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(CreateDataBaseImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

}
