package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.tsaplin.statistics.Ngram;
import com.artech.prototype2.tsaplin.statistics.StatisticSaverToDB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 13.12.2014.
 */
public class StatisticSaverToDBImpl implements StatisticSaverToDB{
    @Override
    public void saveOneRuWordStatistic(NgramStatisticImpl statistic, AbstractSUBD bd) {
        //получить список из бд
        DictionaryRuDaoImpl dictionaryRuDao = new DictionaryRuDaoImpl();
        List<DictionaryRu> list = dictionaryRuDao.getAll(bd);


        //обновлять данные, проверяя есть ли такие

       /* for(Map.Entry<Ngram, Integer> entry: statistic.getMapWithStatistic().entrySet()){
            DictionaryRu dictionary= entry.getKey().makeDictionary(entry.getValue());
        }
        */
        //писать в бд


        //Чтобы реализовать конструкцию, создаю отдельные классы для соотв статистик с нграммами,
        //далее добавляю методы, возвращающие соответствующие листы из словарей, потом мержу словари в базу
    }


}
