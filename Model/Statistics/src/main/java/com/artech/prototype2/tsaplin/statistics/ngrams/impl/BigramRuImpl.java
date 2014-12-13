package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.BigramRuVarOne;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractBigram;

/**
 * Created by User on 13.12.2014.
 */
public class BigramRuImpl extends AbstractBigram {
    public BigramRuImpl(String first, String second){super(first, second);}

    public BigramRuImpl(BigramRuVarOne bigramRuVarOne){
        this.setFirst(bigramRuVarOne.getWordOne());
        this.setSecond(bigramRuVarOne.getWordTwo());
    }

    @Override
    public Entity makeDictionary(int count) {
        return new BigramRuVarOne(this.getFirst(), this.getSecond(), count);
    }
}
