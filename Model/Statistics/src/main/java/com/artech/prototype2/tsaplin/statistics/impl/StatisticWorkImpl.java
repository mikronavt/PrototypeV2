package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.StatisticWork;
import com.artech.prototype2.tsaplin.utils.impl.FileParserImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Класс для работы со статистикой.
 *
 * Created by atsaplin on 03.12.2014.
 */
public class StatisticWorkImpl implements StatisticWork{

    public static void main(String[] args) throws Throwable{
        String fileName = "";
        StatisticWorkImpl statisticWork = new StatisticWorkImpl();
        statisticWork.getStatisticFromFile(fileName, "txt");

    }

    /**
     * Метод для получения статистики из файла и загрузки ее в БД.
     * Использует метод fileParser.getListOfWordsFromFile, чтобы получить список слов из файла.
     * На основе списка слов составляется статистика для н-грамм (н от 1 до 4), с помощью методов класса StatisticMaker.
     * Статистика загружается в базу данных.
     *
     * @param fileName - имя файла с текстом
     * @param format - формат данных в файле ("txt", "pdf", "doc" ...)
     * @throws IOException
     */
    public void getStatisticFromFile(String fileName, String format) throws IOException{
        FileParserImpl fileParser = new FileParserImpl();
        ArrayList<String> words = fileParser.getListOfWordsFromFile(fileName, format);

        StatisticMakerImpl statisticMaker = new StatisticMakerImpl();
        HashMap<String, Integer> singleWordStatistic = statisticMaker.makeStatistic(words, 1);

        HashMap<String, Integer> bigramStatistic = statisticMaker.makeStatistic(words, 2);

        HashMap<String, Integer> trigramStatistic = statisticMaker.makeStatistic(words, 3);

        HashMap<String, Integer> tetragramStatistic = statisticMaker.makeStatistic(words, 4);

        //дальше надо залить все в базу
    }
}
