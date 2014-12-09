/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.vreshetnyak.output;

<<<<<<< HEAD
//import com.artech.prototype2.saver.titov.dao.DAO;
=======
>>>>>>> 597ccd622350bf56700fab5f54c14cd51b9711c5

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
