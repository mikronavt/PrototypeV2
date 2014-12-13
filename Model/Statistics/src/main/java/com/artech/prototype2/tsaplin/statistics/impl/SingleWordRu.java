package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.entity.DictionaryRu;

/**
 * Created by User on 13.12.2014.
 */
public class SingleWordRu extends SingleWord {

    public SingleWordRu(String word){super(word);}

    public DictionaryRu makeDictionary(int count){
        return new DictionaryRu(word, count);
    }

}
