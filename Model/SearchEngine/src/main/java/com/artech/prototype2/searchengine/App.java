package com.artech.prototype2.searchengine;

import com.artech.prototype2.bardakov.crauler.Crawler;
import com.artech.prototype2.bardakov.crauler.impl.CrawlerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Crawler robot = new CrawlerImpl();
        String test = robot.getURL(robot.getContentOfHTTPPage("http://inosmi.ru/history/", "UTF-8"));
        System.out.println(test);
    }
}
