package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.tsaplin.statistics.impl.NgramStatisticImpl;

import java.util.ArrayList;


/**
 * Интерфейс для создания статистик.
 *
 * Created by atsaplin on 03.12.2014.
 */
public interface StatisticMaker {

    /**
     * Создание статистики для одиночных слов.
     *
     * @param words - список слов.
     * @return - статистика одиночных слов.
     */
    public NgramStatisticImpl makeSingleWordStatistic(ArrayList<String> words);

    /**
     * Создание статистики для биграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика биграмм.
     */
    public NgramStatisticImpl makeBigramStatistic(ArrayList<String> words);

    /**
     * Создание статистики для триграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для триграмм.
     */
    public NgramStatisticImpl makeThreegramStatistic(ArrayList<String> words);

    /**
     * Создание статистики для фограмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для фограмм.
     */
    public NgramStatisticImpl makeFourgramStatistic(ArrayList<String> words);


}
