/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.io.api;

import com.artech.prototype2.io.common.Common;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author artem
 */
public class InOutApiImpl implements IOAPI{
    
    protected Map<String, Common> system;
    
    
    public InOutApiImpl(){
        init();
    }

    private void init() {
        system = new HashMap<String, Common>();
    }
    
    public void addSystem(String name, Common inOut){
        system.put(name, inOut);
    }
    
    public Common getSystem(String name){
        return system.get(name);
    }
}
