package com.artech.prototype2.tsaplin.statistics.indexes.impl;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.indexes.IndexCounter;

import java.util.ArrayList;

/**
 * Created by User on 23.12.2014.
 */
public class IndexCounterImpl implements IndexCounter {
    @Override
    public Integer countDocid(String fileName, AbstractSUBD db, String lang) {
        return null;
    }

    @Override
    public Integer countPosition(ArrayList<String> wordsInDoc, String word) {
        return null;
    }

    @Override
    public Float countTf(Integer docSize, Integer countOfWord) {
        return null;
    }

    @Override
    public Float countIdf(AbstractSUBD db, String lang, Integer countOfWordInDocs) {
        return null;
    }

    @Override
    public Float countTfIdf(Float tf, Float idf) {
        return null;
    }
}
