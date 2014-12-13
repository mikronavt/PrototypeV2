package com.artech.prototype2.tsaplin.statistics.impl.ngrams;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.ThreegramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.impl.ngrams.Threegram;

/**
 * Created by User on 13.12.2014.
 */
public class ThreegramRu extends Threegram {
    public ThreegramRu(String first, String second, String third){super(first, second, third);}

    public ThreegramRu(ThreegramRuVarOne threegramRuVarOne){
        this.setFirst(threegramRuVarOne.getWordOne());
        this.setSecond(threegramRuVarOne.getWordTwo());
        this.setThird(threegramRuVarOne.getWordThree());
    }

    @Override
    public Entity makeDictionary(int count) {
        return new ThreegramRuVarOne(this.getFirst(), this.getSecond(), this.getThird(), count);
    }
}
