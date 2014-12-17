package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dao.AbstractDao;
import com.artech.prototype2.saver.dao.impl.DictionaryEnDaoImpl;
import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.BigramRuVarOne;
import com.artech.prototype2.saver.entity.DictionaryEn;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.tsaplin.statistics.StatisticSaverToDB;
import com.artech.prototype2.tsaplin.statistics.ngrams.AbstractNgram;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.BigramRuImpl;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordEnImpl;
import com.artech.prototype2.tsaplin.statistics.ngrams.impl.SingleWordRuImpl;
import com.artech.prototype2.tsaplin.statistics.statisticholder.AbstractNgramStatistic;
import com.artech.prototype2.tsaplin.statistics.statisticholder.impl.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 13.12.2014.
 */
public class StatisticSaverToDBImpl implements StatisticSaverToDB {


    @Override
    public void saveStatisticToDB(SingleWordRuStatisticImpl statistic, AbstractSUBD db) {
        //получить список из бд
        String label = "dict_ru_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DictionaryRuDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db);

        /*HashMap<SingleWordRuImpl, Integer> mapDictionaryId = new HashMap<SingleWordRuImpl, Integer>();
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
        } */

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }

    }

    private List<Entity> makeListOfSaveAndUpdate(SingleWordRuStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<SingleWordRuImpl, Integer> mapDictionaryId = new HashMap<SingleWordRuImpl, Integer>();
        HashMap<SingleWordRuImpl, Integer> mapDictionaryCount = new HashMap<SingleWordRuImpl, Integer>();

        for (Entity ent : listFromDb) {
            DictionaryRu dict = (DictionaryRu) ent;
            mapDictionaryCount.put(new SingleWordRuImpl(dict), dict.getCount());
            mapDictionaryId.put(new SingleWordRuImpl(dict), dict.getRuid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<SingleWordRuImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                DictionaryRu dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setRuid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                DictionaryRu dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }

        return saveAndUpdateList;

    }

    @Override
    public void saveStatisticToDB(SingleWordEnStatisticImpl statistic, AbstractSUBD db) {
        String label = "dict_en_dao";
        ManagerAPISaver.getInstance().registry(label, db, new DictionaryEnDaoImpl());
        List<Entity> listFromDb = ManagerAPISaver.getInstance().getAll(label, db);

        List<Entity> saveAndUpdateList = makeListOfSaveAndUpdate(statistic, listFromDb);

        for (Entity ent : saveAndUpdateList) {
            ManagerAPISaver.getInstance().saveOrUpdate(label, db, ent);
        }
    }

    private List<Entity> makeListOfSaveAndUpdate(SingleWordEnStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<SingleWordEnImpl, Integer> mapDictionaryId = new HashMap<SingleWordEnImpl, Integer>();
        HashMap<SingleWordEnImpl, Integer> mapDictionaryCount = new HashMap<SingleWordEnImpl, Integer>();

        for (Entity ent : listFromDb) {
            DictionaryEn dict = (DictionaryEn) ent;
            mapDictionaryCount.put(new SingleWordEnImpl(dict), dict.getCount());
            mapDictionaryId.put(new SingleWordEnImpl(dict), dict.getEnid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<SingleWordEnImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                DictionaryEn dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setEnid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                DictionaryEn dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }


    @Override
    public void saveStatisticToDB(BigramRuStatisticImpl statistic, AbstractSUBD db) {

    }

    private List<Entity> makeListOfSaveAndUpdate(BigramRuStatisticImpl statistic, List<Entity> listFromDb) {
        HashMap<BigramRuImpl, Integer> mapDictionaryId = new HashMap<BigramRuImpl, Integer>();
        HashMap<BigramRuImpl, Integer> mapDictionaryCount = new HashMap<BigramRuImpl, Integer>();

        for (Entity ent : listFromDb) {
            BigramRuVarOne dict = (BigramRuVarOne) ent;
            mapDictionaryCount.put(new BigramRuImpl(dict), dict.getCount());
            mapDictionaryId.put(new BigramRuImpl(dict), dict.getRuid());
        }

        List<Entity> saveAndUpdateList = new ArrayList<Entity>();

        for (Map.Entry<BigramRuImpl, Integer> entry : statistic.entrySet()) {
            if (mapDictionaryCount.containsKey(entry.getKey())) {
                BigramRuVarOne dictionaryToUpdate = entry.getKey().makeDictionary(entry.getValue() + mapDictionaryCount.get(entry.getKey()));
                dictionaryToUpdate.setRuid(mapDictionaryId.get(entry.getKey()));
                saveAndUpdateList.add(dictionaryToUpdate);
            } else {
                BigramRuVarOne dictionaryToSave = entry.getKey().makeDictionary(entry.getValue());
                saveAndUpdateList.add(dictionaryToSave);
            }
        }
        return saveAndUpdateList;
    }

    @Override
    public void saveStatisticToDB(BigramEnStatisticImpl statistic, AbstractSUBD db) {

    }

    @Override
    public void saveStatisticToDB(ThreegramRuStatisticImpl statistic, AbstractSUBD db) {

    }

    @Override
    public void saveStatisticToDB(ThreegramEnStatisticImpl statistic, AbstractSUBD db) {

    }

    @Override
    public void saveStatisticToDB(FourgramRuStatisticImpl statistic, AbstractSUBD db) {

    }

    @Override
    public void saveStatisticToDB(FourgramEnStatisticImpl statistic, AbstractSUBD db) {

    }
}