package com.artech.prototype2.saver;

import com.artech.prototype2.saver.bardakov.dbo.impl.CreateDataBaseImpl;
import com.artech.prototype2.saver.bardakov.dbo.impl.MySQL;
import com.artech.prototype2.saver.dao.impl.DictionaryRuDaoImpl;
import com.artech.prototype2.saver.entity.DictionaryRu;
import com.artech.prototype2.saver.entity.Entity;
import com.artech.prototype2.saver.manager.ManagerAPISaver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ManagerAPISaver.getInstance().registry("create_db", new CreateDataBaseImpl());
        ManagerAPISaver.getInstance().createDB(new MySQL("dbconnect/dbconnect.properties"));
        
        String label = "dict_ru_dao";
        ManagerAPISaver.getInstance().registry(label, new DictionaryRuDaoImpl());
        Entity entity = new DictionaryRu();
        ((DictionaryRu)entity).setWord("example");
        ((DictionaryRu)entity).setCount(3);
        
        ManagerAPISaver.getInstance().delete(label, entity);
        ManagerAPISaver.getInstance().getAll(label);
       
    }
}
