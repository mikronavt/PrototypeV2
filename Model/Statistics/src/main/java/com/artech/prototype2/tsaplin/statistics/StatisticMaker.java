package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;

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
    public SingleWordRuStatisticImpl makeSingleWordRuStatistic(ArrayList<String> words);

    public SingleWordEnStatisticImpl makeSingleWordEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для биграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика биграмм.
     */
    public BigramRuStatisticImpl makeBigramRuStatistic(ArrayList<String> words);

    public BigramEnStatisticImpl makeBigramEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для триграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для триграмм.
     */
    public ThreegramRuStatisticImpl makeThreegramRuStatistic(ArrayList<String> words);

    public ThreegramEnStatisticImpl makeThreegramEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для фограмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для фограмм.
     */
    public FourgramRuStatisticImpl makeFourgramRuStatistic(ArrayList<String> words);

    public FourgramEnStatisticImpl makeFourgramEnStatistic(ArrayList<String> words);


}
