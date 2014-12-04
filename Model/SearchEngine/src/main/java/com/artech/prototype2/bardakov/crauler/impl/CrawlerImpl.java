/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.bardakov.crauler.impl;

import com.artech.prototype2.bardakov.crauler.Crawler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс описывает работу поискового робота, который занимается индексированием
 * сайтов и поиска конкретных статей
 *
 * @author artem
 */
public class CrawlerImpl implements Crawler {

    protected Map<String, List<String>> index = null;
    protected List<String> urls = null; //список url-ов на странице

    public CrawlerImpl() {
        urls = new ArrayList<String>();
        index = new HashMap<String, List<String>>();
    }

    public List<String> getUrls() {
        return urls;
    }

    /**
     * функция возвращает HTML код указанной страницы вторым параметром
     * принимает кодировку (например "UTF8")
     */
    public StringBuilder getContentOfHTTPPage(String pageAddress, String codePage) {
        StringBuilder sb = null;
        URL pageURL = null;
        URLConnection uc = null;
        BufferedReader br = null;
        try {
            sb = new StringBuilder();
            pageURL = new URL(pageAddress);
            uc = pageURL.openConnection();
            br = new BufferedReader(new InputStreamReader(uc.getInputStream(), codePage));
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
        } catch (IOException ioexp) {
            ioexp.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(CrawlerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sb;
    }

    /**
     * получить HTML страницу по URL Кодировка по умолчанию UTF-8
     *
     * @param pageAddress адрес странцы индексирования
     * @return функция возвращает HTML код указанной страницы
     */
    public StringBuilder getContentOfHTTPPageUTF8(String pageAddress) {
        return this.getContentOfHTTPPage(pageAddress, "UTF-8");
    }

    /**
     * получить первый url на странице
     *
     * @param content HTML страница
     * @return
     */
    public int getURL(StringBuilder content) {
        int start = content.indexOf("<a href=\"");
        int len = start + "<a href=\"".length();
        int end = content.indexOf("\"", len);
        String url = content.substring(len, end);
        urls.add(url);
        return start;
    }

    /**
     * Получить url начиная с определенной позиции
     *
     * @param content - HTML страница
     * @param indexStart - стартовый индекс
     * @return - найденный url
     */
    public int getURL(StringBuilder content, int indexStart) {
        int start = content.indexOf("<a href=\"", indexStart);
        int len = start + "<a href=\"".length();
        int end = content.indexOf("\"", len);
        String url = content.substring(len, end);
        urls.add(url);
        return start;
    }

    /**
     * Получить все URL на странице
     *
     * @param content HTML код страницы
     * @return
     */
    public List<String> getAllURLPage(StringBuilder content) {
        int index = 0;
        while (index != -1) {
            index = getURL(content, index + 1);
        }
        return urls;
    }

    public void Print() {
        for (String url : urls) {
            System.out.println(url);
        }
    }

    /**
     * Получение всех url заданного ресурса
     *
     * @param url страница с которой начинается получение urls
     * @param breaking количество циклов индексирования
     */
    public void createIndexUrl(String url, int count) {
        StringBuilder content = getContentOfHTTPPageUTF8(url);
        getAllURLPage(content);
        List<String> resources = new ArrayList<String>();
        String uri = "";
        for (int i = 0; i<urls.size()&& i<count; i++) {
            uri = urls.get(i);
            if (resources.indexOf(uri) == -1 && isHttp(uri)) {
                content = getContentOfHTTPPageUTF8(uri);
                getAllURLPage(content);
                resources.add(uri);
            }
        }
    }

    
    protected boolean isHttp(String uri){
        return uri.indexOf("http") != -1;
    }
}
