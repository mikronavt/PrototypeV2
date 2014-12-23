package com.artech.prototype2.tsaplin.statistics.indexes;

import com.artech.prototype2.saver.dbo.AbstractSUBD;

import java.util.ArrayList;

/**
 * Created by User on 23.12.2014.
 */
public interface IndexCounter {

    public Integer countDocid(String fileName, AbstractSUBD db, String lang);


    public Integer countPosition(ArrayList<String> wordsInDoc, String word);

    public Float countTf(Integer docSize, Integer countOfWord);

    public Float countIdf(AbstractSUBD db, String lang, Integer countOfWordInDocs);

    public Float countTfIdf(Float tf, Float idf);
}
