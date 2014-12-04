package com.artech.prototype2.tsaplin.statistics;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 03.12.2014.
 */
public interface StatisticMaker {

    public HashMap<String, Integer> makeStatistic (ArrayList<String> words, int wordsInNgram);
}
