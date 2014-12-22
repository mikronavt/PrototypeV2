package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordEnStatisticImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.List;

/**
 * Created by User on 22.12.2014.
 */
public interface IndexesMakerToDB {
    public void reCountRuIdfIndexes();

    public void reCountEnIdfIndexes();

    public void saveOrUpdateWordsInRuIdf(SingleWordRuStatisticImpl statistic);

    public void saveOrUpdateWordsInEnIdf(SingleWordEnStatisticImpl statistic);

    public void addDocumentWordsToRuIndexes(String fileName, List<String> wordsList, SingleWordRuStatisticImpl statistic);

    public void addDocumentWordsToEnIndexes(String fileName, List<String> wordsList, SingleWordEnStatisticImpl statistic);
}
