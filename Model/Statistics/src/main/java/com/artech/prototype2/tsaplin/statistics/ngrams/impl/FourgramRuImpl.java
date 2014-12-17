package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.entity.FourgramRuVarOne;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractFourgram;

/**
 * Created by User on 13.12.2014.
 */
public class FourgramRuImpl extends AbstractFourgram {
    public FourgramRuImpl(String first, String second, String third, String fourth){super(first, second, third, fourth);}

    public FourgramRuImpl(FourgramRuVarOne fourgramRuVarOne){
        this.setFirst(fourgramRuVarOne.getWordOne());
        this.setSecond(fourgramRuVarOne.getWordTwo());
        this.setThird(fourgramRuVarOne.getWordThree());
        this.setFourth(fourgramRuVarOne.getWordFour());
    }

    @Override
    public FourgramRuVarOne makeDictionary(int count) {
        return new FourgramRuVarOne(this.getFirst(), this.getSecond(), this.getThird(), this.getFourth(), count);
    }
}
