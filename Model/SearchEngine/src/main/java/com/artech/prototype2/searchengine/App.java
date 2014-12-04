package com.artech.prototype2.searchengine;

import com.artech.prototype2.bardakov.crauler.Crawler;
import com.artech.prototype2.bardakov.crauler.impl.CrawlerImpl;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Crawler robot = new CrawlerImpl();
        robot.getAllURL(robot.getContentOfHTTPPageUTF8("http://inosmi.ru/history/"));
        ((CrawlerImpl)robot).Print();
        
    }
}
