package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.tsaplin.statistics.StatisticSaverToDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 13.12.2014.
 */
public class StatisticSaverToDBImpl implements StatisticSaverToDB{
    @Override
    public void saveOneRuWordStatistic(NgramStatisticImpl statistic, AbstractSUBD bd) {
        //получить список из бд
        DictionaryRuDaoImpl dictionaryRuDao = new DictionaryRuDaoImpl();
        List<DictionaryRu> list = dictionaryRuDao.getAll(bd);

        List<DictionaryRu> newList;



        //сравнивать со статистикой

        //обновлять данные

        //писать в бд
    }


}
