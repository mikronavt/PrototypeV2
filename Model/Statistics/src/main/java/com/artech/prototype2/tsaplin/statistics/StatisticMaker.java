package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.tsaplin.statistics.impl.statistics.NgramStatisticAbstract;

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
    public NgramStatisticAbstract makeSingleWordStatistic(ArrayList<String> words, String lang);

    /**
     * Создание статистики для биграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика биграмм.
     */
    public NgramStatisticAbstract makeBigramStatistic(ArrayList<String> words, String lang);

    /**
     * Создание статистики для триграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для триграмм.
     */
    public NgramStatisticAbstract makeThreegramStatistic(ArrayList<String> words, String lang);

    /**
     * Создание статистики для фограмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для фограмм.
     */
    public NgramStatisticAbstract makeFourgramStatistic(ArrayList<String> words, String lang);


}
