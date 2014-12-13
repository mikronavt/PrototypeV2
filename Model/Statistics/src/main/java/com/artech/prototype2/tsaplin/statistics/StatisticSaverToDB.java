package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

/**
 * Created by User on 13.12.2014.
 */
public interface StatisticSaverToDB {
    public void saveOneRuWordStatistic(AbstractNgramStatistic statistic, AbstractSUBD bd);
}
