package com.artech.prototype2.tsaplin.statistics.impl.ngrams;

import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.tsaplin.statistics.impl.ngrams.SingleWord;

/**
 * Created by User on 13.12.2014.
 */
public class SingleWordRu extends SingleWord {

    public SingleWordRu(String word){super(word);}

    public SingleWordRu(DictionaryRu dictionaryRu){
        this.setWord(dictionaryRu.getWord());
    }

    public DictionaryRu makeDictionary(int count){
        return new DictionaryRu(this.getWord(), count);
    }



}
