package com.artech.prototype2.tsaplin.statistics.impl.ngrams;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.ThreegramEnVarOne;
import com.artech.prototype2.tsaplin.statistics.impl.ngrams.Threegram;

/**
 * Created by User on 13.12.2014.
 */
public class ThreegramEn extends Threegram {
    public ThreegramEn(String first, String second, String third){super(first, second, third);}

    public ThreegramEn(ThreegramEnVarOne threegramEnVarOne){
        this.setFirst(threegramEnVarOne.getWordOne());
        this.setSecond(threegramEnVarOne.getWordTwo());
        this.setThird(threegramEnVarOne.getWordThree());
    }

    @Override
    public Entity makeDictionary(int count) {
        return new ThreegramEnVarOne(this.getFirst(), this.getSecond(), this.getThird(), count);
    }
}
