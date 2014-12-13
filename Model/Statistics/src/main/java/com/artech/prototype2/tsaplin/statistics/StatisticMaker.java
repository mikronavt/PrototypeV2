package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.tsaplin.statistics.impl.statistics.*;

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
    public SingleWordRuStatistic makeSingleWordRuStatistic(ArrayList<String> words);

    public SingleWordEnStatistic makeSingleWordEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для биграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика биграмм.
     */
    public BigramRuStatistic makeBigramRuStatistic(ArrayList<String> words);

    public BigramEnStatistic makeBigramEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для триграмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для триграмм.
     */
    public ThreegramRuStatistic makeThreegramRuStatistic(ArrayList<String> words);

    public ThreegramEnStatistic makeThreegramEnStatistic(ArrayList<String> words);

    /**
     * Создание статистики для фограмм на основе списка слов.
     *
     * @param words - список слов.
     * @return - статистика для фограмм.
     */
    public FourgramRuStatistic makeFourgramRuStatistic(ArrayList<String> words);

    public FourgramEnStatistic makeFourgramEnStatistic(ArrayList<String> words);


}
