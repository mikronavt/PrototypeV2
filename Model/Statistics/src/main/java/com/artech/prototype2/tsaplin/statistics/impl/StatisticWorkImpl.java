package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.StatisticWork;
import com.artech.prototype2.tsaplin.utils.impl.FileParserImpl;
import com.sun.org.glassfish.external.statistics.impl.StatisticImpl;

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
        String fileName = "C:\\1\\3.txt";
        StatisticWorkImpl statisticWork = new StatisticWorkImpl();
        statisticWork.getFullStatisticFromFileToDB(fileName, "txt");


    }

    /**
     * Метод для получения статистики из файла и загрузки ее в БД.
     * Использует метод fileParser.getListOfWordsFromFile, чтобы получить список слов из файла.
     * На основе списка слов составляются статистики для н-грамм (н от 1 до 4), с помощью методов класса StatisticMaker.
     * Статистика загружается в базу данных.
     *
     * @param fileName - имя файла с текстом
     * @param format - формат данных в файле ("txt", "pdf", "doc" ...)
     * @throws IOException
     */
    public void getFullStatisticFromFileToDB(String fileName, String format) throws IOException{
        FileParserImpl fileParser = new FileParserImpl();
        ArrayList<String> words = fileParser.getListOfWordsFromFile(fileName, format);

        //Здесь должен быть какой-то способ определения языка для файла
        String lang = "ru";


        StatisticMakerImpl statisticMaker = new StatisticMakerImpl();
        NgramStatisticImpl singleWordStatistic = statisticMaker.makeSingleWordStatistic(words, lang);

        NgramStatisticImpl bigramStatistic = statisticMaker.makeBigramStatistic(words, lang);

        NgramStatisticImpl trigramStatistic = statisticMaker.makeThreegramStatistic(words, lang);

        NgramStatisticImpl fourgramStatistic = statisticMaker.makeFourgramStatistic(words, lang);

        //дальше надо залить все в базу
    }
}
