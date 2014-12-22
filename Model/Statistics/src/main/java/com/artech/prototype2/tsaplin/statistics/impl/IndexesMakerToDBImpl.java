package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.tsaplin.statistics.IndexesMakerToDB;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordEnStatisticImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.List;

/**
 * Created by User on 22.12.2014.
 */
public class IndexesMakerToDBImpl implements IndexesMakerToDB {
    @Override
    public void reCountRuIdfIndexes() {

    }

    @Override
    public void reCountEnIdfIndexes() {

    }

    @Override
    public void saveOrUpdateWordsInRuIdf(SingleWordRuStatisticImpl statistic) {

    }

    @Override
    public void saveOrUpdateWordsInEnIdf(SingleWordEnStatisticImpl statistic) {

    }

    @Override
    public void addDocumentWordsToRuIndexes(String fileName, List<String> wordsList, SingleWordRuStatisticImpl statistic) {

    }

    @Override
    public void addDocumentWordsToEnIndexes(String fileName, List<String> wordsList, SingleWordEnStatisticImpl statistic) {

    }
}
