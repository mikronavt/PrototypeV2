package com.artech.prototype2.tsaplin.utils.impl;

import com.artech.prototype2.tsaplin.utils.FileParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс вытягивает из файлов текст в удобном для обработки виде.
 *
 *
 * Created by atsaplin on 03.12.2014.
 */
public class FileParserImpl implements FileParser{


    /**
     *  Метод возвращает список слов для данного файла данного формата.
     *  В работе вызывает метод для соответствующего формата файла.
     * @param fileName - имя файла
     * @param format - формат данных файла (txt, doc, ...)
     * @return ArrayList со списком слов файла
     * @throws IOException
     */
    public ArrayList<String> getListOfWordsFromFile(String fileName, String format) throws IOException{

        if ("txt".equals(format.toLowerCase())) return  getListOfWordsFromTxt(fileName);
        else  return  getListOfWordsFromTxt(fileName);

    }

    /**
     * Метод обрабатывает txt-файл, достает из него слова, возвращает их в виде списка.
     * Под словами сейчас подразумеваются группы символов, разделенные пробелами.
     *
     * @param fileName - имя файла
     * @return ArrayList со списком слов файла, слова идут в том порядке, в котором они были в файле
     * @throws IOException
     */
    private ArrayList<String> getListOfWordsFromTxt(String fileName) throws IOException{
        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        ArrayList<String> words = new ArrayList<String>();
        String s;

        while ((s = reader.readLine())!=null){
            String[] arrayOfWords = s.split(" ");
            for (int i = 0; i < arrayOfWords.length; i++) {
                String word = arrayOfWords[i];
                words.add(word);
            }
        }

        return words;
    }
}
