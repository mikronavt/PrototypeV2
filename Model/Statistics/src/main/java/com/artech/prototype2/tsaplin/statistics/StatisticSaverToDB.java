package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

/**
 * Created by User on 13.12.2014.
 */
public interface StatisticSaverToDB {
    public void saveSingleWordRuStatistic(SingleWordRuStatisticImpl statistic, AbstractSUBD bd);
}
