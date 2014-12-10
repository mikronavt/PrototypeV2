package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.tsaplin.statistics.impl.NgramStatisticImpl;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Интерфейс для создания статистик.
 *
 * Created by atsaplin on 03.12.2014.
 */
public interface StatisticMaker {

    /**
     * Метод создает и возвращает HashMap nGramStatistic со статистикой для н-грамм на основе списка слов.
     * В HashMap ключом является н-грамм, значением - то, сколько раз она встречается в файле.
     *
     * @param words - список со словами
     * @param wordsInNgram - число слов, входящих в одну нграмму
     * @return статистика для н-грамм.
     */
    //public HashMap<String, Integer> makeStatistic (ArrayList<String> words, int wordsInNgram);
    public NgramStatisticImpl makeSingleWordStatistic(ArrayList<String> words);

    public NgramStatisticImpl makeBigramStatistic(ArrayList<String> words);

    public NgramStatisticImpl makeThreegramStatistic(ArrayList<String> words);

    public NgramStatisticImpl makeFourgramStatistic(ArrayList<String> words);


}
