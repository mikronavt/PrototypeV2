package com.artech.prototype2.saver;

import com.artech.prototype2.saver.titov.fillerdb.CreatorDB;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CreatorDB.executeScripts();
        System.out.println( "Hello World!" );
    }
}
