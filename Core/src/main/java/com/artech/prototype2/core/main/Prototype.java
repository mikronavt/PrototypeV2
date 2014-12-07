/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.core.main;

import com.artech.prototype2.saver.titov.daoimpl.HibernateUtil;
import com.artech.prototype2.saver.titov.fillerdb.CreatorDB;
import com.artech.prototype2.vreshetnyak.input.Input;
import com.artech.prototype2.vreshetnyak.input.impl.InputFormImpl;

/**
 * Основоной класс всей системы
 * В нем осуществляется взаимодействие всех 
 * компонентов системы
 * @author CANDY
 */
public class Prototype {

    /**
     * Инициализация компонентов системы
     * Предобработка 
     */
    public Prototype() {
        createForms();
        initDataBase();
    }

    /**
     * Метод создает 2 формы
     * одна форма ввода
     * другая форма вывода
     */
    protected void createForms(){
        createInput();
        createOutput();
    }
    
    /**
     * Метод создает форму ввода
     */
    protected void createInput(){
        Input input = new InputFormImpl();
        input.InputGUIForm();
    }
    
    /**
     * Метод создает формы вывода
     */
    protected void createOutput(){
        
    }
    
    /**
     * Основной метод жизненного цикла всей системы
     * Запускает систему
     */
    public void lifecycle() {
        
    }

    /**
     * Создание и проверка на существование
     * всех бд и таблиц
     */
    protected void initDataBase() {
        CreatorDB.executeScripts();
        HibernateUtil.createSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}
