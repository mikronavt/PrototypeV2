package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.DictionaryEn;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractSingleWord;

/**
 * Created by User on 13.12.2014.
 */
public class SingleWordEnImpl extends AbstractSingleWord {
    public SingleWordEnImpl(String word){super(word);}

    public SingleWordEnImpl(DictionaryEn dictionaryEn){
        this.setWord(dictionaryEn.getWord());
    }

    @Override
    public Entity makeDictionary(int count) {
        return new DictionaryEn(this.getWord(), count);
    }
}
