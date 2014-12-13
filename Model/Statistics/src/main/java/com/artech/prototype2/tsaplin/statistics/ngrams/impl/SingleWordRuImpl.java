package com.artech.prototype2.tsaplin.statistics.ngrams.impl;

import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractSingleWord;

/**
 * Created by User on 13.12.2014.
 */
public class SingleWordRuImpl extends AbstractSingleWord {

    public SingleWordRuImpl(String word){super(word);}

    public SingleWordRuImpl(DictionaryRu dictionaryRu){
        this.setWord(dictionaryRu.getWord());
    }

    public DictionaryRu makeDictionary(int count){
        return new DictionaryRu(this.getWord(), count);
    }



}
