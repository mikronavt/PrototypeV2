
package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.StatisticMaker;
import com.artech.prototype2.tsaplin.statistics.impl.ngrams.*;
import com.artech.prototype2.tsaplin.statistics.impl.statistics.*;

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
    public SingleWordRuStatistic makeSingleWordRuStatistic(ArrayList<String> words) {
        SingleWordRuStatistic singleWordStatistic = new SingleWordRuStatistic();

        for (int i = 0; i < words.size(); i++) {
             SingleWordRu word = new SingleWordRu(words.get(i));
             singleWordStatistic.plusOneNgram(word);
        }

        return singleWordStatistic;
    }

    @Override
    public SingleWordEnStatistic makeSingleWordEnStatistic(ArrayList<String> words) {
        SingleWordEnStatistic singleWordStatistic = new SingleWordEnStatistic();

        for (int i = 0; i < words.size(); i++) {
            SingleWordEn word = new SingleWordEn(words.get(i));
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
    public BigramRuStatistic makeBigramRuStatistic(ArrayList<String> words) {
        BigramRuStatistic bigramStatistic = new BigramRuStatistic();

        for (int i = 1; i < words.size(); i++) {
            BigramRu bigram = new BigramRu(words.get(i - 1), words.get(i));
            bigramStatistic.plusOneNgram(bigram);
        }

        return bigramStatistic;
    }

    @Override
    public BigramEnStatistic makeBigramEnStatistic(ArrayList<String> words) {
        BigramEnStatistic bigramStatistic = new BigramEnStatistic();

        for (int i = 1; i < words.size(); i++) {
            BigramEn bigram = new BigramEn(words.get(i - 1), words.get(i));
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
    public ThreegramRuStatistic makeThreegramRuStatistic(ArrayList<String> words) {
        ThreegramRuStatistic threegramStatistic = new ThreegramRuStatistic();

        for (int i = 2; i < words.size(); i++) {

            ThreegramRu threegram;
            threegram = new ThreegramRu(words.get(i - 2), words.get(i - 1), words.get(i));

            threegramStatistic.plusOneNgram(threegram);
        }

        return threegramStatistic;
    }

    @Override
    public ThreegramEnStatistic makeThreegramEnStatistic(ArrayList<String> words) {
        ThreegramEnStatistic threegramStatistic = new ThreegramEnStatistic();

        for (int i = 2; i < words.size(); i++) {

            ThreegramEn threegram;
            threegram = new ThreegramEn(words.get(i - 2), words.get(i - 1), words.get(i));

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
    public FourgramRuStatistic makeFourgramRuStatistic(ArrayList<String> words) {
        FourgramRuStatistic fourgramStatistic = new FourgramRuStatistic();

        for (int i = 3; i < words.size(); i++) {

            FourgramRu fourgram;
            fourgram = new FourgramRu(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));

            fourgramStatistic.plusOneNgram(fourgram);
        }

        return fourgramStatistic;
    }

    @Override
    public FourgramEnStatistic makeFourgramEnStatistic(ArrayList<String> words) {
        FourgramEnStatistic fourgramStatistic = new FourgramEnStatistic();

        for (int i = 3; i < words.size(); i++) {

            FourgramEn fourgram;
            fourgram = new FourgramEn(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));

            fourgramStatistic.plusOneNgram(fourgram);
        }

        return fourgramStatistic;
    }
}
