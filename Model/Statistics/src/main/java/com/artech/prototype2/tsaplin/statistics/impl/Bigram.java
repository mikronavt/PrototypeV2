package com.artech.prototype2.tsaplin.statistics.impl;

import java.util.List;

/**
 * Класс, реализующий биграмм.
 *
 * Created by atsaplin on 09.12.2014.
 */
public class Bigram extends NgramImpl{

    String first;
    String second;

    /**
     * Конструктор для класса.
     *
     * @param first - первое слово.
     * @param second - второе слово.
     */
    public Bigram(String first, String second){
        this.first = first;
        this.second = second;
    }

    /**
     * Геттер для н-ного слова.
     *
     * @param n - номер слова.
     * @return слово в виде строки, null при ошибочном n
     */
    @Override
    public String getNthWord(int n) {
        switch (n){
            case 1: return first;
            case 2: return second;
        }
        return null;
    }

    /**
     * Сеттер для н-ного слова.
     *
     * @param word - слово, которое требуется подставить.
     * @param n - позиция, в которую надо записать слово.
     */
    @Override
    public void setNthWord(String word, int n) {
        switch (n){
            case 1: this.first = word;
                break;
            case 2: this.second = word;
        }
    }
}
