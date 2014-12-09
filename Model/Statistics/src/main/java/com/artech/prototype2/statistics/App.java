package com.artech.prototype2.statistics;

import com.artech.prototype2.saver.bardakov.utils.impl.CreateDataBaseImpl;
import com.artech.prototype2.saver.bardakov.utils.impl.MySQL;
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
    }
}
