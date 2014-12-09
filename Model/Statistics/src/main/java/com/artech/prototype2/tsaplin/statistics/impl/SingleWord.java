package com.artech.prototype2.tsaplin.statistics.impl;

import java.text.SimpleDateFormat;

/**
 * Класс, реализующий одиночное слово.
 *
 * Created by atsaplin on 09.12.2014.
 */
public class SingleWord extends NgramImpl {

    String word;

    /**
     * Конструктор для класса.
     *
     * @param word - строка, на основании которой создается слово.
     */
    public SingleWord(String word){
        this.word = word;
    }



    /**
     * Сеттер для класса.
     *
     * @param word - слово, которое требуется подставить.
     * @param n - позиция, в которую надо ставить слово.
     */
    public void setNthWord(String word, int n){
        if(n == 1) this.word = word;
    }

    /**
     * Геттер для класса.
     *
     * @param n - номер слова.
     * @return - слово в виде строки, null при ошибочном n
     */
    public String getNthWord(int n){
        if(n == 1) return word;
        else return null;
    }

}
