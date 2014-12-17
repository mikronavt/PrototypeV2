package com.artech.prototype2.tsaplin.statistics;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;

/**
 * Created by User on 13.12.2014.
 */
public interface StatisticSaverToDB {
    public void saveStatisticToDB(SingleWordRuStatisticImpl statistic, AbstractSUBD db);

    public void saveStatisticToDB(SingleWordEnStatisticImpl statistic, AbstractSUBD db);

    public void saveStatisticToDB(BigramRuStatisticImpl statistic, AbstractSUBD db);

    public void saveStatisticToDB(BigramEnStatisticImpl statistic, AbstractSUBD db);

    public void saveStatisticToDB(ThreegramRuStatisticImpl statistic, AbstractSUBD db);

    public void saveStatisticToDB(ThreegramEnStatisticImpl statistic, AbstractSUBD db);

    public void saveStatisticToDB(FourgramRuStatisticImpl statistic, AbstractSUBD db);

    public void saveStatisticToDB(FourgramEnStatisticImpl statistic, AbstractSUBD db);
}
