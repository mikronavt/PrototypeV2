
package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.StatisticMaker;
import com.artech.prototype2.tsaplin.statistics.impl.ngrams.*;
import com.artech.prototype2.tsaplin.statistics.impl.statistics.NgramStatisticAbstract;

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
    public NgramStatisticAbstract makeSingleWordStatistic(ArrayList<String> words, String lang) {
        NgramStatisticAbstract singleWordStatistic = new NgramStatisticAbstract();

        for (int i = 0; i < words.size(); i++) {
            SingleWord word;
            if("en".equals(lang)) {
                word = new SingleWordEn(words.get(i));
            }
            else if("ru".equals(lang)){
                word = new SingleWordRu(words.get(i));
            }
            else{
                word = new SingleWordRu(words.get(i));
            }
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
    public NgramStatisticAbstract makeBigramStatistic(ArrayList<String> words, String lang) {
        NgramStatisticAbstract bigramStatistic = new NgramStatisticAbstract();

        for (int i = 1; i < words.size(); i++) {
            Bigram bigram;
            if ("en".equals(lang)){
                bigram = new BigramEn(words.get(i - 1), words.get(i));
            }
            else if("ru".equals(lang)){
                bigram = new BigramRu(words.get(i - 1), words.get(i));
            }
            else {
                bigram = new BigramEn(words.get(i - 1), words.get(i));
            }

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
    public NgramStatisticAbstract makeThreegramStatistic(ArrayList<String> words, String lang) {
        NgramStatisticAbstract threegramStatistic = new NgramStatisticAbstract();

        for (int i = 2; i < words.size(); i++) {

            Threegram threegram;
            if("en".equals(lang)){
                threegram = new ThreegramEn(words.get(i - 2), words.get(i - 1), words.get(i));
            }
            else if("ru".equals(lang)){
                threegram = new ThreegramRu(words.get(i - 2), words.get(i - 1), words.get(i));
            }
            else{
                threegram= new ThreegramRu(words.get(i - 2), words.get(i - 1), words.get(i));
            }

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
    public NgramStatisticAbstract makeFourgramStatistic(ArrayList<String> words, String lang) {
        NgramStatisticAbstract fourgramStatistic = new NgramStatisticAbstract();

        for (int i = 3; i < words.size(); i++) {

            Fourgram fourgram;

            if("en".equals(lang)){
                fourgram = new FourgramEn(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));
            }
            else if("ru".equals(lang)){
                fourgram = new FourgramRu(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));
            }
            else{
                fourgram = new FourgramRu(words.get(i - 3), words.get(i - 2), words.get(i - 1), words.get(i));
            }

            fourgramStatistic.plusOneNgram(fourgram);
        }

        return fourgramStatistic;
    }
}
