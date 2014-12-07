package com.artech.prototype2.searchengine;

import com.artech.prototype2.bardakov.crawler.Crawler;
import com.artech.prototype2.bardakov.crawler.impl.CrawlerImpl;
import com.artech.prototype2.saver.titov.daoimpl.HibernateUtil;
import com.artech.prototype2.saver.titov.fillerdb.CreatorDB;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        CreatorDB.executeScripts();
        HibernateUtil.createSessionFactory();
        HibernateUtil.getSessionFactory().close();
        Crawler robot = new CrawlerImpl();
        String url = "http://inosmi.ru/";
        robot.createIndexUrl(url,12);
        ((CrawlerImpl)robot).Print();
        
    }
}
