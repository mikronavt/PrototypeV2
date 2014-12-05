/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.fillerdb;

import com.artech.prototype2.saver.titov.fillerdb.impl.CreateObjectsToRepository;
import com.artech.prototype2.saver.titov.fillerdb.impl.CreateObjectsToRepositoryMySQLImpl;
import java.io.File;

/**
 *
 * @author Zhenya
 * основной класс этого пакета
 * вызывается функция executeScripts, 
 * после которой находятся скрипты, создаюся таблицы
 */
public class CreatorDB {          
    // создаю объект который будет заливать скрипты в БД
    static private CreateObjectsToRepository getCreateObjectsToRepository(String s){
        if(s.equals("mysql")) return new CreateObjectsToRepositoryMySQLImpl();
        return null;
    }
    
    /**
     * функция которая находит скрипты, 
     * которые надо залить в БД, на данный момент
     * работает только для БД mysql
     */ 
    static public void executeScripts(){
        String path = new File("..\\Saver").getAbsolutePath() + File.separator + "src" + File.separator + "main" + File.separator + "resources";        
//        String path = "C:\\Users\\CANDY\\Dropbox\\PrototypeV2\\Saver\\src\\main\\resources";
        File file = new File(path);
        String[] str = file.list();
        for(String i : str){
            File f = new File(path + File.separator + i);
            if(f.isDirectory())
            {
                CreateObjectsToRepository c = getCreateObjectsToRepository(i);
                if(c == null) continue;
                c.createObjects(path);
                break ;
            }
        }        
    }
}
