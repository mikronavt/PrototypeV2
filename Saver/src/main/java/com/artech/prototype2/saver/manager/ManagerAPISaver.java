/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.saver.manager;

import com.artech.prototype2.saver.bardakov.api.API;
import com.artech.prototype2.saver.bardakov.utils.AbstractSUBD;
import com.artech.prototype2.saver.bardakov.utils.CreateDataBase;
import com.artech.prototype2.saver.bardakov.utils.impl.MySQL;
import java.util.HashMap;
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
    
}
