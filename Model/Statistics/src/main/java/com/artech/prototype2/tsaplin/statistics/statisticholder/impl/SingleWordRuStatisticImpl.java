package com.artech.prototype2.tsaplin.statistics.statisticholder.impl;

import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;

import java.util.List;

/**
 * Created by User on 13.12.2014.
 */
public class SingleWordRuStatisticImpl extends AbstractNgramStatistic<SingleWordRuImpl> {

    public SingleWordRuStatisticImpl(){super();}

    public SingleWordRuStatisticImpl(List<DictionaryRu> list){
        super();
        for(DictionaryRu dict: list){
            this.put(new SingleWordRuImpl(dict), dict.getCount());
        }
    }


}
