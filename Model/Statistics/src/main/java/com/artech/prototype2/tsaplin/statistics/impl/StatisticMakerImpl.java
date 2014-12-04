
package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.StatisticMaker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Класс для получения статистики на основе списка слов.
 *
 *
 * Created by atsaplin on 03.12.2014.
 */
public class StatisticMakerImpl implements StatisticMaker{

    /**
     * Метод создает и возвращает HashMap nGramStatistic со статистикой для н-грамм на основе списка слов.
     * В HashMap ключом является н-грамм, значением - то, сколько раз она встречается в файле.
     * Метод пробегает по списку слов, составляет н-граммы, проверяет их наличие в map-е -
     * если есть, то обновляет значение, если нет, то добавляет со значением 1.
     *
     * @param words - список со словами
     * @param wordsInNgram - число слов, входящих в одну нграмму
     * @return статистика для н-грамм.
     */
    public HashMap<String, Integer> makeStatistic(ArrayList<String> words, int wordsInNgram){
        HashMap<String, Integer> nGramStatistic = new HashMap<String, Integer>();

        for (int i = wordsInNgram - 1; i < words.size(); i++) {
            String nGram = makeNgram(words, wordsInNgram, i);
            if(nGramStatistic.containsKey(nGram)) nGramStatistic.put(nGram, nGramStatistic.get(nGram) + 1);
            else nGramStatistic.put(nGram, 1);
        }

        return nGramStatistic;
    }

    /**
     *Вспомогательный метод, извлекающий из списка слова, создающий и возвращающий н-грамм из этих слов.
     *
     * @param words - список со словами
     * @param wordsInNgram - число слов, входящих в один нграмм
     * @param lastIndex - индекс последнего слова, входящего в н-грамм.
     * @return возвращает нграмм из
     */
    private String makeNgram(ArrayList<String> words, int wordsInNgram, int lastIndex){
        String nGram = new String();
        for (int i = lastIndex - wordsInNgram + 1 ; i <= lastIndex ; i++) {
            nGram = nGram + words.get(i) + " ";
        }
        nGram = nGram.trim();

        return nGram;
    }
}
