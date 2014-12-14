package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.FourgramEnVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.FourgramEnImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.List;

/**
 * Created by User on 14.12.2014.
 */
public class FourgramEnStatisticImpl extends AbstractNgramStatistic<FourgramEnImpl> {
    public FourgramEnStatisticImpl(){super();}

    public FourgramEnStatisticImpl(List<FourgramEnVarOne> list){
        super();
        for(FourgramEnVarOne dict: list){
            this.put(new FourgramEnImpl(dict), dict.getCount());
        }
    }
}
