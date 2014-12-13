package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.ThreegramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractThreegram;

/**
 * Created by User on 13.12.2014.
 */
public class ThreegramRuImpl extends AbstractThreegram {
    public ThreegramRuImpl(String first, String second, String third){super(first, second, third);}

    public ThreegramRuImpl(ThreegramRuVarOne threegramRuVarOne){
        this.setFirst(threegramRuVarOne.getWordOne());
        this.setSecond(threegramRuVarOne.getWordTwo());
        this.setThird(threegramRuVarOne.getWordThree());
    }

    @Override
    public Entity makeDictionary(int count) {
        return new ThreegramRuVarOne(this.getFirst(), this.getSecond(), this.getThird(), count);
    }
}
