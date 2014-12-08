package com.artech.prototype2.searchengine;

import com.artech.prototype2.bardakov.crawler.Crawler;
import com.artech.prototype2.bardakov.crawler.impl.CrawlerImpl;
import com.artech.prototype2.saver.bardakov.utils.HibernateUtil;
import com.artech.prototype2.saver.titov.fillerdb.CreatorDB;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
       
        Crawler robot = new CrawlerImpl();
        String url = "http://inosmi.ru";
        robot.createIndexedUrl(url,20);
        ((CrawlerImpl)robot).Print();
        
    }
}
