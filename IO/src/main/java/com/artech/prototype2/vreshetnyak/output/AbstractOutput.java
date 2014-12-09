/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output;

//import com.artech.prototype2.saver.titov.dao.DAO;

/**
 *
 * @author Василий
 */
public abstract class AbstractOutput implements Output{
    /**
     * Метод возвращает базовую форму ввода данных
     * @param text 
     */
    public abstract void OutputForm(String text);
    /**
     * Метод возвращает форму с таблицей
     * @param nameForm
     * @param nameColumns
     * @param nameTable 
     */
    public abstract void FormReportInit();
}
