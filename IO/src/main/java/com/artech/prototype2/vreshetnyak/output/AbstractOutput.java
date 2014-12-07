/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output;

/**
 *
 * @author Василий
 */
public abstract class AbstractOutput implements Output{
    public abstract void OutputForm(String text);   
    public abstract void FormReport(String[] arg);
}
