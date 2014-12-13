package com.artech.prototype2.tsaplin.statistics.impl.ngrams;

import com.artech.prototype2.saver.entity.BigramRuVarOne;
import com.artech.prototype2.saver.entity.Entity;

/**
 * Created by User on 13.12.2014.
 */
public class BigramRu extends AbstractBigram {
    public BigramRu(String first, String second){super(first, second);}

    public BigramRu(BigramRuVarOne bigramRuVarOne){
        this.setFirst(bigramRuVarOne.getWordOne());
        this.setSecond(bigramRuVarOne.getWordTwo());
    }

    @Override
    public Entity makeDictionary(int count) {
        return new BigramRuVarOne(this.getFirst(), this.getSecond(), count);
    }
}
