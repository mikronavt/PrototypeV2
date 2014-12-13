package com.artech.prototype2.tsaplin.statistics.impl.ngrams;

import com.artech.prototype2.saver.entity.DictionaryEn;
import com.artech.prototype2.saver.entity.Entity;

/**
 * Created by User on 13.12.2014.
 */
public class SingleWordEn extends AbstractSingleWord {
    public SingleWordEn(String word){super(word);}

    public SingleWordEn(DictionaryEn dictionaryEn){
        this.setWord(dictionaryEn.getWord());
    }

    @Override
    public Entity makeDictionary(int count) {
        return new DictionaryEn(this.getWord(), count);
    }
}
