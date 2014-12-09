package com.artech.prototype2.tsaplin.statistics.impl;

/**
 * Класс, реализующий фограммы.
 *
 * Created by atsaplin on 09.12.2014.
 */
public class Fourgram extends NgramImpl {
    String first;
    String second;
    String third;
    String fourth;

    /**
     * Конструктор для класса.
     *
     * @param first
     * @param second
     * @param third
     * @param fourth
     */
    public Fourgram(String first, String second, String third, String fourth){
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    /**
     * Геттер для н-ного слова.
     * @param n - номер слова.
     * @return - слово в виде строки, null при ошибочном n.
     */
    @Override
    public String getNthWord(int n) {
        switch(n){
            case 1: return first;
            case 2: return second;
            case 3: return third;
            case 4: return fourth;
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
            case 1: first = word;
                break;
            case 2: second = word;
                break;
            case 3: third = word;
                break;
            case 4: fourth = word;
                break;
        }
    }
}

