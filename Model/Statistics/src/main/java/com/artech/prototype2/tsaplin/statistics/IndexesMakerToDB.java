package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordEnStatisticImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.List;

/**
 * Created by User on 22.12.2014.
 */
public interface IndexesMakerToDB {
    public void reCountRuIdfIndexes(AbstractSUBD db);

    public void reCountEnIdfIndexes(AbstractSUBD db);

    public void saveOrUpdateWordsInRuIdf(SingleWordRuStatisticImpl statistic, AbstractSUBD db);

    public void saveOrUpdateWordsInEnIdf(SingleWordEnStatisticImpl statistic, AbstractSUBD db);

    public void addDocumentWordsToRuIndexes(String fileName, List<String> wordsList, SingleWordRuStatisticImpl statistic, AbstractSUBD db);

    public void addDocumentWordsToEnIndexes(String fileName, List<String> wordsList, SingleWordEnStatisticImpl statistic, AbstractSUBD db);
}
