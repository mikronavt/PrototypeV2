package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.tsaplin.statistics.StatisticSaverToDB;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.SingleWordRuStatisticImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 13.12.2014.
 */
public class StatisticSaverToDBImpl implements StatisticSaverToDB{



    @Override
    public void saveSingleWordRuStatistic(SingleWordRuStatisticImpl statistic, AbstractSUBD db) {
        //получить список из бд
        String label = "dict_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DictionaryRuDaoImpl());
        List<Entity> list = ManagerAPISaver.getInstance().getAll(label, db);

        HashMap<SingleWordRuImpl, Integer> mapDictionaryId = new HashMap<SingleWordRuImpl, Integer>();
        HashMap<SingleWordRuImpl, Integer> mapDictionaryCount = new HashMap<SingleWordRuImpl, Integer>();

        for(Entity ent: list){
            DictionaryRu dict = (DictionaryRu) ent;
            mapDictionaryCount.put(new SingleWordRuImpl(dict), dict.getCount());
            mapDictionaryId.put(new SingleWordRuImpl(dict), dict.getRuid());
        }

        for(Map.Entry<SingleWordRuImpl, Integer> entry: statistic.entrySet()){
            if(mapDictionaryCount.containsKey(entry.getKey())){
                DictionaryRu dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setRuid(mapDictionaryId.get(entry.getKey()));
                ManagerAPISaver.getInstance().update(label, db, dictionaryToUpdate);
            }
            else{
                DictionaryRu dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                ManagerAPISaver.getInstance().save(label, db, dictionaryToSave);
            }
        }

        //обновлять данные, проверяя есть ли такие

       /* for(Map.Entry<Ngram, Integer> entry: statistic.getMapWithStatistic().entrySet()){
            DictionaryRu dictionary= entry.getKey().makeDictionary(entry.getValue());
        }
        */
        //писать  в бд


        //Чтобы реализовать конструкцию, создаю отдельные классы для соотв статистик с нграммами,
        //далее добавляю методы, возвращающие соответствующие листы из словарей, потом мержу словари в базу
    }


}
