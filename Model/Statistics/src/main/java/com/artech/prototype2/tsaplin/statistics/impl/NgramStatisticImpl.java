package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.tsaplin.statistics.Ngram;
import com.artech.prototype2.tsaplin.statistics.NgramStatistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Класс, хранящий статистику.
 * Хранит статистику в ХэшКарте map, где ключом является нграмма, значением - количество раз, которые она встречалась.
 *
 * Created by atsaplin on 09.12.2014.
 */
public class NgramStatisticImpl implements NgramStatistic {

    private HashMap<Ngram, Integer> map;

    /**
     *
     */
    public NgramStatisticImpl(){
        map = new HashMap<Ngram, Integer>();
    }

    /**
     * Метод увеличивает статистику для одной н-граммы.
     * Если н-грамма уже есть в статистике, то увеличивает значение для нее на 1.
     * Если нет - то добавляет нграмму со значением, равным 1
     * @param ngram
     */
    @Override
    public void plusOneNgram(Ngram ngram) {
        if(map.containsKey(ngram)) map.put(ngram, map.get(ngram) + 1);
        else map.put(ngram, 1);
    }

    /**
     * Метод обновляет статистику для данной нграммы.
     * @param ngram - нграмма
     * @param count - новое значение.
     */
    @Override
    public void updateStatisticForNgram(Ngram ngram, Integer count) {
        map.put(ngram, count);
    }

    /**
     * Метод возвращает HashMap со статистикой для нграмм.
     * @return
     */
    @Override
    public HashMap<Ngram, Integer> getMapWithStatistic() {
        return map;
    }


}
