
package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.StatisticMaker;

import java.util.ArrayList;


/**
 * Класс для получения статистики на основе списка слов.
 *
 *
 * Created by atsaplin on 03.12.2014.
 */
public class StatisticMakerImpl implements StatisticMaker{


    /**
     * Создание статистики для одиночных слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public NgramStatisticImpl makeSingleWordStatistic(ArrayList<String> words) {
        NgramStatisticImpl singleWordStatistic = new NgramStatisticImpl();

        for (int i = 0; i < words.size(); i++) {
            SingleWord word = new SingleWord(words.get(i));
            singleWordStatistic.plusOneNgram(word);
        }

        return singleWordStatistic;
    }

    /**
     * Создание статистики для биграмм на основе списка слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public NgramStatisticImpl makeBigramStatistic(ArrayList<String> words) {
        NgramStatisticImpl bigramStatistic = new NgramStatisticImpl();

        for (int i = 1; i < words.size(); i++) {
            Bigram bigram = new Bigram(words.get(i - 1), words.get(i));
            bigramStatistic.plusOneNgram(bigram);
        }

        return bigramStatistic;
    }

    /**
     * Создание статистики для триграмм на основе списка слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public NgramStatisticImpl makeThreegramStatistic(ArrayList<String> words) {
        NgramStatisticImpl threegramStatistic = new NgramStatisticImpl();

        for (int i = 2; i < words.size(); i++) {
            Threegram threegram = new Threegram(words.get(i - 2), words.get(i - 1), words.get(i));
            threegramStatistic.plusOneNgram(threegram);
        }

        return threegramStatistic;
    }

    /**
     * Создание статистики для фограмм на основе списка слов.
     * @param words - список слов.
     * @return
     */
    @Override
    public NgramStatisticImpl makeFourgramStatistic(ArrayList<String> words) {
        NgramStatisticImpl fourgramStatistic = new NgramStatisticImpl();

        for (int i = 3; i < words.size(); i++) {
            Fourgram fourgram = new Fourgram(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));
            fourgramStatistic.plusOneNgram(fourgram);
        }

        return fourgramStatistic;
    }
}
