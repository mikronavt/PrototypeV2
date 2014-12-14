package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.FourgramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.FourgramRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.List;

/**
 * Created by User on 14.12.2014.
 */
public class FourgramRuStatisticImpl extends AbstractNgramStatistic<FourgramRuImpl> {

    public FourgramRuStatisticImpl(List<FourgramRuVarOne> list){
        super();
        for(FourgramRuVarOne dict: list){
            this.put(new FourgramRuImpl(dict), dict.getCount());
        }
    }
}
