/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output;

/**
 *
 * @author Василий
 */
public interface Output {
    /**
     * Выводит форму с переданным текстом в аргументе. Поддержка многострочности
     * @param text
     */
    public void OutputForm(String text);
    
    /**
     * Выводит форму с таблицей
     * @param arg
     */
    public void OutputFormTable(String[] arg);
    
}
