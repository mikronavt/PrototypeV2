/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.input.impl;

import junit.framework.TestCase;

/**
 *
 * @author Василий
 */
public class InputFormImplTest extends TestCase {
    
    public InputFormImplTest(String testName) {
        super(testName);
    }

    public void testInputGUIForm() {
        System.out.println("InputGUIForm");
        InputFormImpl instance = new InputFormImpl();
        instance.InputGUIForm();
        
        
    }
}
