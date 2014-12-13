package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.entity.DictionaryRu;

import java.text.SimpleDateFormat;

/**
 * Класс, реализующий одиночное слово.
 *
 * Created by atsaplin on 09.12.2014.
 */
public abstract class SingleWord extends NgramImpl {

    private String word;

    /**
     * Конструктор для класса.
     *
     * @param word - строка, на основании которой создается слово.
     */
    public SingleWord(String word){
        this.word = word;
    }

    public SingleWord(){};



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleWord that = (SingleWord) o;

        if (!word.equals(that.word)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }


}
