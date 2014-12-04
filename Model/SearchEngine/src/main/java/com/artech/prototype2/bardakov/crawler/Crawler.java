/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.artech.prototype2.bardakov.crawler;

import java.net.URL;
import java.util.List;

/**
 * описывает основные методы работы поискового робота,
 * который занимается индексированием сайтов
 * и поиска конкретных статей
 * @author artem
 */
public interface Crawler {
    /**
     * функция возвращает HTML код указанной страницы
     * вторым параметром принимает кодировку (например "UTF8")
     * @param pageAddress адрес страницы парсинга
     * @param codePage кодировка страницы
     * @return 
     */
    public StringBuilder getContentOfHTTPPage(String pageAddress, String codePage);
    
    /**
     * функция возвращает HTML код указанной страницы
     * Кодировка по умолчанию "UTF8"
     * @param pageAddress адрес страницы парсинга
     * @return 
     */
    public StringBuilder getContentOfHTTPPageUTF8(String pageAddress);
    
    /**
     * Получение Url на странице
     * @param content HTML код страницы
     * @return 
     */
    public int getURL(String url, StringBuilder content);
    
    /**
     * Получение Url на странице
     * начиная с указанной позиции
     * @param content - HTML код страницы
     * @param indexStart - стартовый индекс
     * @return 
     */
     public int getURL(String url, StringBuilder content, int indexStart);
    
    /**
     * Получить все URL на странице
     * @param content HTML код страницы
     * @return 
     */
    public List<String> getAllURLPage(String url, StringBuilder content);
    
    /**
     * Получение всех url 
     * заданного ресурса
     * @param url страница с которой начинается получение urls
     * @param breaking количество циклов индексирования
     */
    public void createIndexUrl(String url, int breaking);
}
