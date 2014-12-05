/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.fillerdb.impl;

import com.artech.prototype2.saver.titov.fillerdb.ContentFile;
import com.mysql.jdbc.Connection;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhenya находит скрипты, создает их в БД mysql
 */
public class CreateObjectsToRepositoryMySQLImpl implements CreateObjectsToRepository {

    // регистрация драйвера
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("class not found");
        }
    }

    // пользователь mysql
    protected String user;
    // пароль mysql
    protected String password;
    // порт mysql
    protected String port;

    /**
     * возвращает значение параметра(для настройки mysql) от его имени
     *
     * @param name
     * @param list
     * @return
     */
    private String getParameterFromName(String name, List<String> list) {
        for (String s : list) {
            int index = s.indexOf(name);
            if (index >= 0) {
                int begin = index + name.length() + 1;
                String value = s.substring(begin, s.length());
                return value;
            }
        }
        return "";
    }

    /**
     * находит параметры которые нужны для подключения к БД mysql
     *
     * @param p
     */
    private void findParamsMysql(String p) {
        String path = p + File.separator + "parametersmysql.properties";
        if (!isPropFileExists(path)) {
            return;
        }
        List<String> list = ContentFile.getStringsFromPath(path);
        user = getParameterFromName("user", list);
        password = getParameterFromName("password", list);
        port = getParameterFromName("port", list);
    }

    /**
     * проверяю существование файла
     *
     * @param prop
     * @return
     */
    private boolean isPropFileExists(String prop) {
        File f = new File(prop);
        return f.exists();
    }

    /**
     * проверяю на то создает ли этот скрипт БД или нет
     */
    private boolean isScriptToCreateDB(String s) {
        if (s.indexOf("CREATE DATABASE") >= 0) {
            return true;
        }
        return false;
    }

    // получаю Connection для БД
    private Connection getConnectionFromDB(String db) {
        try {
            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + db, user, password);
            return c;
        } catch (SQLException ex) {
            System.out.println("error connection");
            return null;
        }
    }

    /**
     * создаю БД
     *
     * @param db
     * @param sql
     */
    private void implementScriptToDB(String db, String sql) {
        Connection c = getConnectionFromDB(db);
        if (c == null) {
            return;
        }

        PreparedStatement pr;
        try {
            pr = c.prepareStatement(sql);
            pr.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CreateObjectsToRepositoryMySQLImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateObjectsToRepositoryMySQLImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * нахожу порядок скриптов которые надо выполнить
     *
     * @param path
     */
    public void createObjects(String path) {
        findParamsMysql(path);

        String prop = path + File.separator + "quequeScripts.prop";
        if (!isPropFileExists(prop)) {
            return;
        }

        List<String> l = ContentFile.getStringsFromPath(prop);
        if (l.isEmpty()) {
            return;
        }

        List<String> listContents = new ArrayList<String>();
        String scriptToCreateDB = "";
        for (String s : l) {
            String p = path + File.separator + "mysql" + File.separator + s;
            File f = new File(p);
            if (!f.exists()) {
                continue;
            }
            String sql = ContentFile.getContentFileFromPath(p);
            if (isScriptToCreateDB(sql)) {
                scriptToCreateDB = sql;
            } else {
                listContents.add(sql);
            }
        }

        // если есть скрипт который создвет БД, то создаю ее через jdbc
        if (!scriptToCreateDB.isEmpty()) {
            implementScriptToDB("information_schema", scriptToCreateDB);
        }

        // заливаю отстальные скрипты в БД        
        for (String s : listContents) {
            implementScriptToDB("PROTOTYPE", s);
        }
    }
}
