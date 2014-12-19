/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.io.api;

import com.artech.prototype2.io.common.Common;
import com.artech.prototype2.vreshetnyak.input.AbstractInput;
import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author artem
 */
public class InOutApiImpl implements IOAPI {

    private static InOutApiImpl instance;
    protected Map<String, Common> ioContainer;

    public static InOutApiImpl getInstance() {
        if (instance == null) {
            instance = new InOutApiImpl();
        }
        return instance;
    }

    private InOutApiImpl() {
        ioContainer = new HashMap<String, Common>();
    }

    public void registery(String label, Common test) {
        ioContainer.put(label, test);
    }

    public Common getCommon(String label) {
        return ioContainer.get(label);
    }

    public void InputForm(String label) {
        Common test = getCommon(label);
        if (test != null) {
            ((AbstractInput)test).InputGUIForm();// метод InputGUIForm строит и отображает форму
        }
    }

}
