package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.FourgramEnVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractFourgram;

/**
 * Created by User on 13.12.2014.
 */
public class FourgramEnImpl extends AbstractFourgram {
    public FourgramEnImpl(String first, String second, String third, String fourth){super(first, second, third, fourth);}

    public FourgramEnImpl(FourgramEnVarOne fourgramEnVarOne){
        this.setFirst(fourgramEnVarOne.getWordOne());
        this.setSecond(fourgramEnVarOne.getWordTwo());
        this.setThird(fourgramEnVarOne.getWordThree());
        this.setFourth(fourgramEnVarOne.getWordFour());
    }

    @Override
    public FourgramEnVarOne makeDictionary(int count) {
        return new FourgramEnVarOne(this.getFirst(), this.getSecond(), this.getThird(), this.getFourth(), count);
    }
}
